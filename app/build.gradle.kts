plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization") version "2.3.20"
    alias(libs.plugins.composeCompiler)
}

group = "me.gimmesomepeace"
version = "unspecified"

dependencies {
    implementation(projects.data)
    implementation(projects.core)
    implementation(projects.uiKit)
    implementation(projects.features.characters.browser)

    // Подгружаем библиотеки для отображения UI в текущей ОС (skiko, к примеру)
    implementation(compose.desktop.currentOs)

    // Compose
    implementation(libs.compose.runtime)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)

    implementation(libs.androidx.lifecycle.runtimeCompose)

    // Используется для подключения к Event Dispatcher и созданию основного UI потока
    implementation(libs.kotlinx.coroutinesSwing)

    implementation(libs.compose.components.resources)

    // Logger
    implementation(libs.kotlin.logging)
    runtimeOnly(libs.logback)
    runtimeOnly(libs.logstash)

    // Сериализация
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.11.0")

    implementation("com.arkivanov.decompose:decompose:3.5.0")
    implementation("com.arkivanov.decompose:extensions-compose:3.5.0")

    implementation("media.kamel:kamel-image:1.0.8")
    implementation("media.kamel:kamel-image-default:1.0.8")
}

tasks.test {
    useJUnitPlatform()
}
