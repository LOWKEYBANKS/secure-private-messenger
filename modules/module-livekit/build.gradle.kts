plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("maven-publish")
}

android {
    namespace = "com.lowkeybanks.bitchat.module.livekit"
    compileSdk = 34
    
    defaultConfig {
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        // Video calling configuration
        buildConfigField("int", "
                    
                        ƒ
                        VIDEO DEFAULT RESOLUTION WIDTH
                    
                ", "1280")
        buildConfigField("int", "
                    
                        ƒ
                        VIDEO DEFAULT RESOLUTION HEIGHT
                    
                ", "720")
        buildConfigField("int", "
                    
                        ƒ
                        VIDEO DEFAULT FPS
                    
                ", "30")
        buildConfigField("boolean", "
                    
                        ƒ
                        VIDEO DEFAULT ENABLED
                    
                ", "true")
    }
    
    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            buildConfigField("boolean", "
                    
                        ƒ
                        ENABLE VIDEO DEBUG
                    
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
                        ENABLE VIDEO DEBUG
                    
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
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
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
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    
    // LiveKit SDK
    implementation("io.livekit:livekit-android:2.2.11")
    
    // Local project dependencies
    implementation(project(":libs:livekit:livekit-android-sdk"))
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
                artifactId = "module-livekit"
                version = "1.0.0"
            }
        }
    }
}
