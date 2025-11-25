plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.lowkeybanks.bitchat.payments"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    api(project(":libs:zeus"))
}
