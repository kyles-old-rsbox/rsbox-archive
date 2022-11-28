plugins {
    java
}

dependencies {
    implementation("org.bouncycastle:bcprov-jdk15on:1.52")
    implementation("org.json:json:20220320")
    implementation("com.formdev:flatlaf:_")
    implementation("com.formdev:flatlaf-intellij-themes:_")
}

sourceSets {
    main.get().java {
        srcDirs.addAll(arrayOf(file("src/main/kotlin/")))
    }
}

tasks {
    val run = register<JavaExec>("run client") {
        dependsOn(build.get())
        group = "rsbox"
        mainClass.set("ClientLauncher")
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

    compileJava {
        sourceCompatibility = JavaVersion.VERSION_11.toString()
        targetCompatibility = JavaVersion.VERSION_11.toString()
        options.encoding = "UTF-8"
    }
}