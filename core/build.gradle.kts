plugins {
    kotlin("jvm")

    alias(libs.plugins.detekt)
}

group = "me.gimmesomepeace"
version = "1.0.0"

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
}
