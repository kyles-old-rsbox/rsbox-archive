plugins {
    kotlin("jvm")
}

tasks.wrapper {
    gradleVersion = "7.5.1"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    group = "io.rsbox"
    version = "209.1.1"

    repositories {
        mavenLocal()
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib"))
        implementation(kotlin("reflect"))
    }

    tasks {
        compileKotlin {
            kotlinOptions.jvmTarget = "11"
        }
    }
}