plugins {
    kotlin("plugin.serialization") version "1.7.20"
}

dependencies {
    implementation(project(":toolbox:asm"))
    implementation("org.tinylog:tinylog-api-kotlin:_")
    implementation("org.tinylog:tinylog-impl:_")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:_")
}

tasks {
    val run = register<JavaExec>("run deobfuscator") {
        dependsOn(build.get())
        group = "toolbox"
        mainClass.set("io.rsbox.toolbox.deobfuscator.Deobfuscator")
        main = mainClass.get()
        classpath = sourceSets["main"].runtimeClasspath
    }

    register<Jar>("shadowJar") {
        dependsOn(build.get())
        group = "build"
        archiveClassifier.set("shaded")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        manifest {
            attributes["Main-Class"] = run.get().mainClass.get()
        }
        from(configurations.runtimeClasspath.get().map {
            if(it.isDirectory) it
            else zipTree(it)
        })
        with(jar.get())
    }
}