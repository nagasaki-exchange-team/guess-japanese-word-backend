plugins {
    application
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
    id("io.ktor.plugin")
    id("io.sentry.jvm.gradle")
}

group = "com.ray.study.ktor"
version = libs.versions.versionname.get()

application {
    mainModule = "com.ray.study.ktor"
    mainClass = "com.ray.study.ktor.ApplicationKt"

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

//sentry {
//    // Generates a JVM (Java, Kotlin, etc.) source bundle and uploads your source code to Sentry.
//    // This enables source context, allowing you to see your source
//    // code as part of your stack traces in Sentry.
//    includeSourceContext = true
//
//    org = "ray-pi"
//    projectName = "ktor"
//    authToken = System.getenv("SENTRY_AUTH_TOKEN")
//}

dependencies {
    implementation(project(":common"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":presentation"))

    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.presentation)
    implementation(libs.bundles.data)

    implementation(libs.logback)
    implementation(libs.dagger2)
    ksp(libs.dagger2.compiler)
}
