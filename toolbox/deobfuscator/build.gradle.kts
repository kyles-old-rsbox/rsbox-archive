plugins {
    kotlin("plugin.serialization") version "1.7.20"
    application
}

dependencies {
    implementation(project(":toolbox:asm"))
    implementation("org.tinylog:tinylog-api-kotlin:_")
    implementation("org.tinylog:tinylog-impl:_")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:_")
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