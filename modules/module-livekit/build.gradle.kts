plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "modules.module_livekit"
    compileSdk = 34
}

dependencies {
    api(project(":libs:livekit"))
}
