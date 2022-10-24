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

package io.rsbox.toolbox.updater

import kotlinx.serialization.Serializable

@Serializable
data class ObfuscatedInfo(
    val classes: List<ClassObfuscatedInfo>,
    val methods: List<MethodObfuscatedInfo>,
    val fields: List<FieldObfuscatedInfo>
)

@Serializable
data class ClassObfuscatedInfo(
    val name: String,
    val obfName: String?,
    val jarIndex: Int
)

@Serializable
data class MethodObfuscatedInfo(
    val owner: String,
    val name: String,
    val desc: String,
    val obfOwner: String?,
    val obfName: String?,
    val obfDesc: String?,
    val opaque: Int?
)

@Serializable
data class FieldObfuscatedInfo(
    val owner: String,
    val name: String,
    val desc: String,
    val obfOwner: String?,
    val obfName: String?,
    val obfDesc: String?
)