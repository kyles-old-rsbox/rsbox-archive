/*
 * Copyright (C) 2022 RSBox <Kyle Escobar>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.rsbox.server.cache.model

import io.guthix.js5.container.XTEA_ZERO_KEY
import io.rsbox.server.cache.Cache
import io.rsbox.server.cache.GameCache
import io.rsbox.server.cache.disk.Container
import io.rsbox.server.common.inject

data class Archive(
    var id: Int,
    var version: Int,
    val compression: Compression = Compression.NONE,
    private val groupInfos: Map<Int, Group.Info>,
    private val containsNameHash: Boolean,
    private val containsSizes: Boolean,
) {

    private val cache: GameCache by inject()

    fun readGroup(group: Int, xteaKeys: IntArray = XTEA_ZERO_KEY): Group {
        val info = groupInfos[group] ?: throw IllegalArgumentException("Unable to read [Archive: $id, Group: $group].")
        val data = Group.Data.decode(
            Container.decode(cache.filestore.read(id, group), xteaKeys),
            info.files.size
        )
        val files = hashMapOf<Int, File>()
        var i = 0
        info.files.forEach { (id, info) ->
            files[id] = File(id, info.nameHash, data.fileData[i])
            i++
        }
        return Group(info.id, info.version, data.chunks, info.nameHash, data.compression, files)
    }

   companion object {

       private const val FLAG_NAME_HASH = 0x01
       private const val FLAG_SIZES = 0x04
       private const val FLAG_UNC_CRC = 0x08

       fun decode(container: Container): Archive {
           val buf = container.data
           val format = buf.readUnsignedByte().toInt()
           val version = if(format == 5) -1 else buf.readInt()
           val flags = buf.readUnsignedByte().toInt()
           val containsNameHash = flags and FLAG_NAME_HASH != 0
           val containsSizes = flags and FLAG_SIZES != 0
           val containsUncHash = flags and FLAG_UNC_CRC != 0
           val groupCount = buf.readUnsignedShort()
           val groupIds = IntArray(groupCount)
           var groupId = 0
           for(i in groupIds.indices) {
               groupId += buf.readUnsignedShort()
               groupIds[i] = groupId
           }
           val nameHashes = if(containsNameHash) IntArray(groupCount) {
               buf.readInt()
           } else null
           val compressedCrcs = IntArray(groupCount) { buf.readInt() }
           val uncompressedCrcs = if(containsUncHash) IntArray(groupCount) {
               buf.readInt()
           } else null
           val sizes = if(containsSizes) Array(groupCount) {
               buf.readInt() to buf.readInt()
           } else null
           val versions = Array(groupCount) { buf.readInt() }
           val fileIds = Array(groupCount) {
               IntArray(buf.readUnsignedShort())
           }
           for(group in fileIds) {
               var fileId = 0
               for(i in group.indices) {
                   fileId += buf.readUnsignedShort()
                   group[i] = fileId
               }
           }
           val groupFileNameHashes = if(containsNameHash) {
               Array(groupCount) {
                   IntArray(fileIds[it].size) { buf.readInt() }
               }
           } else null
           val groupInfos = hashMapOf<Int, Group.Info>()
           for(group in groupIds.indices) {
               val fileInfos = hashMapOf<Int, File.Info>()
               for(file in fileIds[group].indices) {
                   fileInfos[fileIds[group][file]] = File.Info(
                       fileIds[group][file],
                       groupFileNameHashes?.get(group)?.get(file) ?: -1
                   )
               }
               val compressedSize = sizes?.get(group)?.first ?: -1
               val uncompressedSize = sizes?.get(group)?.second ?: -1
               groupInfos[groupIds[group]] = Group.Info(
                   groupIds[group],
                   versions[group],
                   compressedCrcs[group],
                   nameHashes?.get(group) ?: -1,
                   compressedSize,
                   uncompressedSize,
                   fileInfos
               )
           }
           return Archive(
               -1,
               version,
               container.compression,
               groupInfos,
               containsNameHash,
               containsSizes
           )
       }
   }
}