dependencies {
    implementation(project(":server:common"))
    implementation(project(":server:util"))
    implementation(project(":server:logger"))
    implementation(project(":server:cache"))
    implementation(project(":server:config"))
    implementation("io.netty:netty-all:_")
    implementation("com.google.guava:guava:_")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:_")
    implementation("io.github.classgraph:classgraph:_")
    implementation("com.github.rsbox:pathfinder:598abc0357")
}