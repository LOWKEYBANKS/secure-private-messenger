plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.lowkeybanks.bitchat.modules.core.crypto"
    compileSdk = 34
    
    defaultConfig {
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        // Crypto Configuration
        buildConfigField("String", "
                    
                        ƒ
                        CIPHER ALGORITHM
                    
                ", "\"AES/GCM/NoPadding\"")
        buildConfigField("String", "
                    
                        ƒ
                        KEY ALGORITHM
                    
                ", "\"X25519\"")
        buildConfigField("int", "
                    
                        ƒ
                        CIPHER KEY SIZE
                    
                ", "256")
    }
    
    buildTypes {
        debug {
            isDebuggable = true
            buildConfigField("boolean", "
                    
                        ƒ
                        CRYPTO DEBUG
                    
                ", "true")
        }
        
        release {
            isDebuggable = false
            isMinifyEnabled = true
            buildConfigField("boolean", "
                    
                        ƒ
                        CRYPTO DEBUG
                    
                ", "false")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.
                    
                        ƒ
                        VERSION 17
                    
                
        targetCompatibility = JavaVersion.
                    
                        ƒ
                        VERSION 17
                    
                
    }
    
    kotlinOptions {
        jvmTarget = "17"
    }
    
    buildFeatures {
        buildConfig = true
    }
    
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core Android
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    
    // Dependencies on our libs
    implementation(project(":libs:libsodium"))
    implementation(project(":libs:briar"))
    
    // Signal Protocol for end-to-end encryption
    implementation("org.whispersystems:signal-protocol-java:2.8.0")
    implementation("org.whispersystems:curve25519-java:0.5.1")
    
    // Advanced Cryptography
    implementation("com.google.crypto.tink:tink-android:1.9.0")
    implementation("org.bouncycastle:bcprov-jdk18on:1.77")
    
    // Key Management
    implementation("androidx.security:security-crypto:1.1.0-alpha06")
    
    // Utilities
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    
    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-inline:5.2.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
