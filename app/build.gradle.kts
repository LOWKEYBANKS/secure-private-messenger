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
        
        multiDexEnabled = true
    }
    
    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            applicationIdSuffix = ".debug"
        }
        
        release {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
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
    
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core Android Libraries
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    
    // Security & Privacy Libraries
    implementation("info.guardianproject.netcipher:netcipher:2.1.0")
    
    // Database
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    
    // Networking & TOR
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("co.infinum:android-pretty-logger:1.0.0")
    
    // Cryptographic Libraries (External Dependencies)
    implementation("org.whispersystems:curve25519-java:0.5.1")
    implementation("org.whispersystems:signal-protocol-java:2.8.0")
    
    // MultiDex Support
    implementation("androidx.multidex:multidex:2.0.1")
    
    // Testing Dependencies
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}



