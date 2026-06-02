plugins {
    kotlin("jvm") version "2.3.20"
    id("org.jetbrains.compose")
    alias(libs.plugins.composeCompiler)
}

group = "me.gimmesomepeace"
version = "unspecified"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(projects.core)
    implementation(projects.uiKit)

    // Compose
    implementation(libs.compose.runtime)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.8.4")

    implementation(libs.kotlinx.coroutinesSwing)
    implementation(libs.compose.components.resources)

    implementation("media.kamel:kamel-image:1.0.8")
    implementation("media.kamel:kamel-image-default:1.0.8")

    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}