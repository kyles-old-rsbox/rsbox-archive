plugins {
    application
}

dependencies {
    implementation("org.ow2.asm:asm:_")
    implementation("org.ow2.asm:asm-util:_")
    implementation("org.ow2.asm:asm-commons:_")
    implementation("org.ow2.asm:asm-tree:_")
    implementation("it.unimi.dsi:fastutil:_")
    implementation("com.google.guava:guava:_")
    implementation("org.tinylog:tinylog-api-kotlin:_")
    implementation("org.tinylog:tinylog-impl:_")
}

application {
    mainClass.set("io.rsbox.toolbox.deobfuscator.Deobfuscator")
}

tasks.named<JavaExec>("run") {
    main = application.mainClass.get()
    workingDir = rootProject.projectDir
}

tasks {
    register<Jar>("shadowJar") {
        dependsOn(build.get())
        group = "build"
        archiveClassifier.set("shaded")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        manifest {
            attributes["Main-Class"] = application.mainClass.get()
        }
        from(configurations.runtimeClasspath.get().map {
            if(it.isDirectory) it
            else zipTree(it)
        })
        with(jar.get())
    }
}