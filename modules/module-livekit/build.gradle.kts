plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "modules.module_livekit"
    compileSdk = 34
}

dependencies {
    implementation(project(":libs:livekit"))
}
