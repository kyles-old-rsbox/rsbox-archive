dependencies {
    implementation(project(":toolbox:asm"))
    implementation("org.tinylog:tinylog-api-kotlin:_")
    implementation("org.tinylog:tinylog-impl:_")
}

tasks {
    val run = register<JavaExec>("run") {
        dependsOn(build.get())
        group = "application"
        mainClass.set("io.rsbox.toolbox.updater.Updater")
        main = mainClass.get()
        classpath = sourceSets["main"].runtimeClasspath
    }

    register<Jar>("shadowJar") {
        dependsOn(build.get())
        group = "build"
        archiveClassifier.set("shaded")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        manifest {
            attributes["Main-Class"] = (run as JavaExec).mainClass.get()
        }
        from(configurations.runtimeClasspath.get().map {
            if(it.isDirectory) it
            else zipTree(it)
        })
        with(jar.get())
    }
}