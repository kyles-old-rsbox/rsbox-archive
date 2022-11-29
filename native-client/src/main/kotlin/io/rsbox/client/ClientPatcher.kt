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

package io.rsbox.client

import org.tinylog.kotlin.Logger
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Files

object ClientPatcher {

    /**
     * === SETTINGS ===
     */
    private const val TITLE = "RSBOX Native Client"
    private const val SERVER_IP = "127.0.0.1"
    private val RSA_MODULUS = ClientPatcher::class.java.getResource("/modulus.txt")!!.readText()

    /*
     * Original client constants
     */
    private const val origRsa = "a65afc7b11a18da1a1bd0e144ea1883463fa040a57341006cec6556954e275446d8b0a222076a68fb0cb6d1fcaa9e7969affe6d5c42ccdba314e465d6dcf69a2bce2c6c70abc884349a2e31bf334ba712e4f7cda455562a80f3ceb1134e6459974780798ef38221e2fa1b9bd6560e120258f366e732b75bd7a385f07a5f5330d\u0000"
    private const val origJavConfigUrl = "http://oldschool.runescape.com/jav_config.ws?m=0\u0000"
    private const val origTitle = "Old School RuneScape\u0000"

    val baseDir = File("native-client/src/main/resources/bin/")

    @JvmStatic
    fun main(args: Array<String>) {
        Logger.info("Patching Old School RuneScape native client binary.")

        if(!baseDir.exists()) {
            throw FileNotFoundException("Could not find binary files in the project resources.")
        }

        val origFile = baseDir.parentFile.parentFile.parentFile.parentFile.resolve("bin/osclient.orig.exe")
        val patchedFile = baseDir.resolve("osclient.exe")

        val data = origFile.readBytes()

        /*
         * Run all required patching steps.
         */
        Logger.info("Running patches.")

        patchRsa(data)
        patchJavConfigUrl(data)
        patchTitle(data)

        Logger.info("Successfully completed all patches.")

        /*
         * Export the patched bytes and overwrite original file.
         */
        Logger.info("Saving patched bytes to original file.")

        patchedFile.deleteRecursively()
        Files.write(patchedFile.toPath(), data)

        Logger.info("Client patcher completed successfully. File: 'osclient.exe' successfully patched.")
    }

    private fun patchRsa(data: ByteArray) {
        Logger.info("Patching RSA public modulus.")
        if(!data.replaceFirst(origRsa.toByteArray(Charsets.US_ASCII), (RSA_MODULUS+"\u0000").toByteArray(Charsets.US_ASCII))) {
            error("Failed to patch RSA public modulus.")
        }
    }

    private fun patchJavConfigUrl(data: ByteArray) {
        Logger.info("Patching jav_config.ws URL address.")
        if(!data.replaceFirst(origJavConfigUrl.toByteArray(Charsets.US_ASCII), "http://$SERVER_IP/jav_config.ws\u0000".toByteArray(Charsets.US_ASCII))) {
            error("Failed to patch jav_config.ws URL address.")
        }
    }

    private fun patchTitle(data: ByteArray) {
        Logger.info("Patching program title.")
        if(!data.replaceFirst(origTitle.toByteArray(Charsets.US_ASCII), (TITLE+"\u0000").toByteArray(Charsets.US_ASCII))) {
            error("Failed to patch program title.")
        }
    }

    fun ByteArray.replaceFirst(needle: ByteArray, replacement: ByteArray): Boolean {
        val index = indexOf(needle)
        if (index == -1) {
            return false
        }

        for (x in index until index + replacement.size) {
            this[x] = replacement[x - index]
        }

        return true
    }

    private fun ByteArray.indexOf(needle: ByteArray): Int {
        outer@ for (i in 0 until this.size - needle.size + 1) {
            for (j in needle.indices) {
                if (this[i + j] != needle[j]) {
                    continue@outer
                }
            }
            return i
        }
        return -1
    }
}