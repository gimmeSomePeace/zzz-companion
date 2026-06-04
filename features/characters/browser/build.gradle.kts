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
    implementation(projects.data)
    implementation(projects.features.characters.catalog)
    implementation(projects.features.characters.filters)

    // Compose
    implementation(libs.compose.runtime)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation("org.jetbrains.androidx.lifecycle:lifecycle-runtime-compose:2.8.4")

    implementation(libs.kotlinx.coroutinesSwing)
    implementation(libs.compose.components.resources)

    // Decompose
    implementation("com.arkivanov.decompose:decompose:3.5.0")
    implementation("com.arkivanov.decompose:extensions-compose:3.5.0")

    implementation(libs.kotlinx.coroutinesSwing)

    // Logging
    implementation(libs.kotlin.logging)

    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}
