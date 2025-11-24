plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "libs.tor"
    compileSdk = 34
}

dependencies {
    api("info.guardianproject.netcipher:netcipher:2.1.0")
    implementation("info.guardianproject:arti-mobile-ex:1.2.3")
}
