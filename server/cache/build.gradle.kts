dependencies {
    implementation(project(":server:common"))
    implementation(project(":server:util"))
    implementation(project(":server:logger"))
    api("io.guthix:js5-filestore:_")
    api("io.guthix:js5-container:_")
    implementation("io.netty:netty-buffer:_")
    implementation("org.apache.commons:commons-compress:_")
}