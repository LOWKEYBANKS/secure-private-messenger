plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.lowkeybanks.bitchat.libs.walletconnect"
    compileSdk = 34
    
    defaultConfig {
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        // WalletConnect Configuration
        buildConfigField("String", "
                    
                        ƒ
                        WC PROJECT ID
                    
                ", "\"your-walletconnect-project-id\"")
        buildConfigField("String", "
                    
                        ƒ
                        WC RELAY URL
                    
                ", "\"wss://relay.walletconnect.com\"")
        buildConfigField("boolean", "
                    
                        ƒ
                        WC ENABLE DAPP SUPPORT
                    
                ", "true")
    }
    
    buildTypes {
        debug {
            isDebuggable = true
            buildConfigField("boolean", "
                    
                        ƒ
                        WC DEBUG
                    
                ", "true")
        }
        
        release {
            isDebuggable = false
            isMinifyEnabled = true
            buildConfigField("boolean", "
                    
                        ƒ
                        WC DEBUG
                    
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
    implementation("androidx.appcompat:appcompat:1.6.1")
    
    // WalletConnect v2
    implementation("com.walletconnect:android-core:1.6.4")
    implementation("com.walletconnect:web3wallet:1.6.4")
    implementation("com.walletconnect:walletconnectmodal:1.6.4")
    
    // Web3 & Ethereum
    implementation("org.web3j:core:5.0.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    
    // Multi-chain Support
    implementation("com.github.komputing:klibethrl:1.1.1")
    implementation("com.github.komputing:khex:1.1.1")
    
    // QR Code & Scanner for dApp connections
    implementation("com.google.zxing:core:3.5.2")
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    
    // Blockchain Utilities
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("com.google.code.gson:gson:2.10.1")
    
    // Secure Storage
    implementation("androidx.security:security-crypto:1.1.0-alpha06")
    
    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:5.8.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
