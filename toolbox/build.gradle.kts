plugins {
    application
}

dependencies {
    implementation(project(":toolbox:deobfuscator"))
    implementation("com.github.ajalt.clikt:clikt:_")
}

application {
    mainClass.set("io.rsbox.toolbox.Toolbox")
}

tasks {
    named<JavaExec>("run") {
        workingDir = rootProject.projectDir
        main = application.mainClass.get()
    }

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