plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader

    // Android
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false

    // Compose
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false

    // Kotlin
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.kotlinJvm) apply false

    alias(libs.plugins.spotless)
}

repositories {
    google()
    mavenCentral()
}

spotless {
    kotlin {
        target("**/*.kt")
        ktlint()
    }

    kotlinGradle {
        target("**/*.gradle.kts")
        ktlint()
    }
}
