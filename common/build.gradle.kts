plugins {
    kotlin("jvm")
    kotlin("kapt")
    id("com.google.devtools.ksp")
}

dependencies {
    implementation(libs.bundles.kotlin)
}
