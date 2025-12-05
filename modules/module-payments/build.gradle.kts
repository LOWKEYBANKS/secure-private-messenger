plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("maven-publish")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.10"
}

android {
    namespace = "com.lowkeybanks.bitchat.module.payments"
    compileSdk = 34
    
    defaultConfig {
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        // Payment configuration
        buildConfigField("String", "
                    
                        ƒ
                        WALLETCONNECT PROJECT ID
                    
                ", "\"your-project-id\"")
        buildConfigField("boolean", "
                    
                        ƒ
                        ENABLE LIGHTNING PAYMENTS
                    
                ", "true")
        buildConfigField("boolean", "
                    
                        ƒ
                        ENABLE WALLETCONNECT
                    
                ", "true")
        buildConfigField("boolean", "
                    
                        ƒ
                        ENABLE CASHU MINTS
                    
                ", "true")
    }
    
    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            buildConfigField("boolean", "
                    
                        ƒ
                        ENABLE PAYMENT DEBUG
                    
                ", "true")
        }
        
        release {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("boolean", "
                    
                        ƒ
                        ENABLE PAYMENT DEBUG
                    
                ", "false")
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
        freeCompilerArgs += listOf(
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=kotlinx.serialization.InternalSerializationApi"
        )
    }
    
    buildFeatures {
        buildConfig = true
        viewBinding = true
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
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.work:work-runtime-ktx:2.9.0")
    
    // WalletConnect v2
    implementation("com.walletconnect:android-core:2.0.0")
    implementation("com.walletconnect:web3modal:2.0.1")
    
    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    implementation("com.google.code.gson:gson:2.10.1")
    
    // Network
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    
    // Cashu e-cash (integration point)
    implementation("com.google.code.gson:gson:2.10.1")
    
    // Local project dependencies
    implementation(project(":libs:zeus"))
    implementation(project(":libs:tor"))
    implementation(project(":modules:core-crypto"))
    
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    
    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

// Publishing configuration
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.lowkeybanks.bitchat"
                artifactId = "module-payments"
                version = "1.0.0"
            }
        }
    }
}

