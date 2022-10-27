plugins {
    kotlin("plugin.serialization") version "1.7.10"
}

dependencies {
    implementation(project(":toolbox:asm"))
    implementation("org.tinylog:tinylog-api-kotlin:_")
    implementation("org.tinylog:tinylog-impl:_")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:_")
    implementation("com.github.Col-E:SimAnalyzer:1.9.2")
    implementation("me.tongfei:progressbar:_")
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
            attributes["Main-Class"] = (run.get() as JavaExec).mainClass.get()
        }
        from(configurations.runtimeClasspath.get().map {
            if(it.isDirectory) it
            else zipTree(it)
        })
        with(jar.get())
    }
}