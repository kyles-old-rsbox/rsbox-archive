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