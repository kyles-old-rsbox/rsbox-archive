dependencies {
    implementation(project(":server:common"))
    implementation(project(":server:util"))
    implementation(project(":server:logger"))
    implementation(project(":server:config"))
    implementation(project(":server:engine"))
    implementation(project(":server:cache"))
    implementation(project(":server:content"))

    project(":server:content").dependencyProject.subprojects.forEach { subproject ->
        if(subproject.buildFile.exists() && subproject.name != project.name) {
            runtimeOnly(subproject)
        }
    }
}

tasks {
    register<JavaExec>("run server") {
        group = "rsbox"
        mainClass.set("io.rsbox.server.launcher.ServerLauncher")
        workingDir = rootProject.projectDir
        classpath = sourceSets["main"].runtimeClasspath
    }

    register<JavaExec>("setup server") {
        group = "rsbox"
        mainClass.set("io.rsbox.server.launcher.ServerSetup")
        workingDir = rootProject.projectDir
        classpath = sourceSets["main"].runtimeClasspath
    }
}