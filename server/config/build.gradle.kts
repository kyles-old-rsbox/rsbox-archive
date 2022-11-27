plugins {
    kotlin("plugin.serialization") version "1.7.20"
}

dependencies {
    implementation(project(":server:common"))
    api("com.uchuhimo:konf:_")
}