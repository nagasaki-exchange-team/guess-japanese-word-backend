plugins {
    `java-library`
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
    id("io.ktor.plugin")
    id("io.sentry.jvm.gradle")
}

// TODO : 제거
application {
    mainClass = "com.ray.study.ktor.ApplicationKt"
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))

    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.presentation)

    implementation(libs.logback)
    implementation(libs.dagger2)
    ksp(libs.dagger2.compiler)
}
