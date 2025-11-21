plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "modules.core_briar"
    compileSdk = 34
}

dependencies {
    implementation(project(":libs:briar"))
}
