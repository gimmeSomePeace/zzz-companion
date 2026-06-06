import dev.detekt.gradle.Detekt

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

    // Lint
    alias(libs.plugins.spotless)
    // Code analysis
    alias(libs.plugins.detekt)
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

subprojects {
    plugins.withId("dev.detekt") {
        tasks.withType<Detekt>().configureEach {
            config.setFrom(rootProject.file("config/detekt/detekt.yml"))
            buildUponDefaultConfig = true
            parallel = true

            reports {
                html.required.set(true)
                html.outputLocation.set(file("build/reports/detekt.html"))

                sarif.required.set(true)
                sarif.outputLocation.set(file("build/reports/detekt.sarif"))
            }
        }
    }
}
