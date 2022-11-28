import groovy.ant.FileNameFinder

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

plugins {
    id("de.fayard.refreshVersions") version "0.50.2"
}

rootProject.name = "rsbox"

/**
 * ===== TOOLBOX =====
 */
include(":toolbox")
include(":toolbox:asm")
include(":toolbox:deobfuscator")
include(":toolbox:updater")

/**
 * ===== CLIENT =====
 */
include(":client")

/**
 * ===== SERVER =====
 */
include(":server")
include(":server:launcher")
include(":server:common")
include(":server:logger")
include(":server:util")
include(":server:engine")
include(":server:cache")
include(":server:config")
includeModules(":server:content")

fun includeModules(module: String) {
    val relativePath = module.substring(1).replace(":", "/")
    val rootDir = rootProject.projectDir.resolve(relativePath)
    if(rootDir.exists()) {
        val buildFiles = FileNameFinder().getFileNames("$rootDir", "**/*.gradle.kts")
        buildFiles.forEach { fileName ->
            val buildFile = File(fileName)
            val moduleDir = buildFile.parentFile
            val relative = rootDir.toPath().relativize(moduleDir.toPath())
            val name = "$relative".replace(File.separator, ":")
            include("$module:$name")
        }
    }
}