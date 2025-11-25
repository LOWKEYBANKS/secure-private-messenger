plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.lowkeybanks.bitchat"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.lowkeybanks.bitchat"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(project(":libs:libsodium"))
    implementation(project(":libs:livekit"))
    implementation(project(":modules:core-crypto"))
    implementation(project(":modules:module-livekit"))
    implementation(project(":modules:module-payments"))
    implementation(project(":libs:tor"))

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    implementation("info.guardianproject.netcipher:netcipher:2.1.0")

    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
}
