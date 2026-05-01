plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    alias(libs.plugins.composeCompiler)
}

group = "org.gimmesomepeace"
version = "unspecified"


dependencies {
    implementation(libs.compose.runtime)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)

    implementation("media.kamel:kamel-image:1.0.8")
    implementation("media.kamel:kamel-image-default:1.0.8")
}

tasks.test {
    useJUnitPlatform()
}