plugins {
    id("de.fayard.refreshVersions") version "0.50.2"
}

rootProject.name = "rsbox"

/**
 * ===== TOOLBOX =====
 */
include(":toolbox")
include(":toolbox:deobfuscator")

/**
 * ===== CLIENT =====
 */
include(":client")

/**
 * ===== SERVER =====
 */
include(":server")