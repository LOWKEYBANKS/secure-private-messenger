plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "modules.core_crypto"
    compileSdk = 34
}

dependencies {
    implementation(project(":libs:libsodium"))
}
