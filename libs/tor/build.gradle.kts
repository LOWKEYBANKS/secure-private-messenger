plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "libs.tor"
    compileSdk = 34
}

dependencies {
    implementation("info.guardianproject.netcipher:netcipher:2.1.0")
}
