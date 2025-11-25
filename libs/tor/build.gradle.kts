plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.lowkeybanks.bitchat.tor"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    api("info.guardianproject.netcipher:netcipher:2.1.0")
    implementation("info.guardianproject:arti-mobile-ex:1.2.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
}
