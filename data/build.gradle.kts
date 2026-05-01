plugins {
    kotlin("jvm")
}

group = "org.gimmesomepeace"
version = "1.0.0"

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation(projects.core)
}
