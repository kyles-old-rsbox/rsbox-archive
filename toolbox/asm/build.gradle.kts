plugins {
    java
}

dependencies {
    api("org.ow2.asm:asm:_")
    api("org.ow2.asm:asm-util:_")
    api("org.ow2.asm:asm-commons:_")
    api("org.ow2.asm:asm-tree:_")
    api("it.unimi.dsi:fastutil:_")
    api("com.google.guava:guava:_")
    implementation("org.apache.commons:commons-lang3:_")
    implementation("commons-io:commons-io:_")
    implementation("com.jcraft:jzlib:1.1.3")
}