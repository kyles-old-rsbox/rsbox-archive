plugins {
    java
}

dependencies {
    implementation("org.bouncycastle:bcprov-jdk15on:1.52")
    implementation("org.json:json:20220320")
    implementation("com.formdev:flatlaf:_")
    implementation("com.formdev:flatlaf-intellij-themes:_")
}

tasks {
    val run = register<JavaExec>("run client") {
        dependsOn(build.get())
        group = "rsbox"
        mainClass.set("io.rsbox.client.ClientLauncher")
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

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        disableAutoTargetJvm()
    }

    compileJava {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
        options.compilerArgs.addAll(arrayOf("-g:source,vars,lines"))
        options.encoding = "UTF-8"
    }
}