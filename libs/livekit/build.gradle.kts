plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "libs.livekit"
    compileSdk = 34
}

dependencies {
    api("io.livekit:livekit-android:2.0.0")
}
