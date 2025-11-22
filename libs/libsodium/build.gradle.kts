plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "libs.libsodium"
    compileSdk = 34
}

dependencies {
    api("com.github.joshjdevl.libsodiumjni:libsodium-jni-aar:2.0.1")
}
