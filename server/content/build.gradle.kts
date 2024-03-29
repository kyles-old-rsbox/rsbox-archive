dependencies {
    api(project(":server:common"))
    api(project(":server:util"))
    api(project(":server:engine"))
    api(project(":server:config"))
    api(project(":server:cache"))
    api(project(":server:logger"))
    implementation(kotlin("scripting-common"))
    api(kotlin("script-runtime"))
    implementation("io.github.classgraph:classgraph:_")
}

subprojects {
    val subproject = this

    dependencies {
        implementation(project(":server:content"))
        project(":server:content").dependencyProject.subprojects.forEach {
            if(it.buildFile.exists() && it.name != project.name) {
                api(it)
            }
        }
    }

    tasks {
        named<Jar>("jar") {
            archiveBaseName.set(subproject.name)
            archiveVersion.set("")
            archiveClassifier.set("")
        }

        register<Copy>("buildContent") {
            group = "build"
            doFirst {
                rootProject.projectDir.resolve("data/content/${subproject.name}.jar").also {
                    if(it.exists()) it.deleteRecursively()
                }
            }
            from(named("jar"))
            into(rootProject.projectDir.resolve("data/content/"))
        }

        compileKotlin {
            finalizedBy(named("buildContent"))
        }
    }
}