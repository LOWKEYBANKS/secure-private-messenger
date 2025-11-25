plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.lowkeybanks.bitchat.core.crypto"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.security:security-crypto:1.1.0-alpha06")
    // Bouncy Castle for crypto operations (Ed25519, etc.)
    api("org.bouncycastle:bcprov-jdk18on:1.76")
}
