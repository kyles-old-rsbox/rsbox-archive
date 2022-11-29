dependencies {
    implementation("org.tinylog:tinylog-api-kotlin:_")
    implementation("org.tinylog:tinylog-impl:_")
}

tasks {
    register<JavaExec>("patch native-client") {
        dependsOn(build.get())
        group = "rsbox"
        workingDir = rootProject.projectDir
        mainClass.set("io.rsbox.client.ClientPatcher")
        classpath = sourceSets["main"].runtimeClasspath
    }

    register<JavaExec>("run native-client") {
        dependsOn(build.get())
        group = "rsbox"
        workingDir = rootProject.projectDir
        mainClass.set("io.rsbox.client.ClientLauncher")
        classpath = sourceSets["main"].runtimeClasspath
    }
}