dependencies {
    implementation(project(":server:common"))
    implementation(project(":server:util"))
    implementation(project(":server:logger"))
    implementation(project(":server:config"))
}

tasks {
    register<JavaExec>("run server") {
        dependsOn(build.get())
        group = "rsbox"
        mainClass.set("io.rsbox.server.launcher.Launcher")
        workingDir = rootProject.projectDir
        classpath = sourceSets["main"].runtimeClasspath
    }
}