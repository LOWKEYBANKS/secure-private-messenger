plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("maven-publish")
}

android {
    namespace = "com.lowkeybanks.bitchat.core.briar"
    compileSdk = 34
    
    defaultConfig {
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        
        // Briar configuration
        buildConfigField("String", "
                    
                        ƒ
                        BRIAR DEFAULT TRANSPORT
                    
                ", "\"bluetooth\"")
        buildConfigField("boolean", "
                    
                        ƒ
                        BRIAR ENABLE MESH
                    
                ", "true")
        buildConfigField("boolean", "
                    
                        ƒ
                        BRIAR ENABLE TOR
                    
                ", "true")
    }
    
    buildTypes {
        debug {
            isDebuggable = true
            isMinifyEnabled = false
            buildConfigField("boolean", "
                    
                        ƒ
                        ENABLE BRIAR DEBUG
                    
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
                        ENABLE BRIAR DEBUG
                    
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
    implementation("androidx.annotation:annotation:1.7.1")
    
    // Database and storage
    implementation("androidx.sqlite:sqlite:2.4.0")
    implementation("androidx.sqlite:sqlite-ktx:2.4.0")
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    
    // Networking and mesh
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    
    // JSON and serialization
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.2")
    
    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    
    // Local project dependencies
    implementation(project(":libs:briar"))
    implementation(project(":modules:core-crypto"))
    implementation(project(":libs:tor"))
    
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
                artifactId = "core-briar"
                version = "1.0.0"
            }
        }
    }
}
