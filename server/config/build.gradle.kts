plugins {
    kotlin("plugin.serialization") version "1.7.20"
}

dependencies {
    implementation(project(":server:common"))
    implementation("com.uchuhimo:konf:_")
}