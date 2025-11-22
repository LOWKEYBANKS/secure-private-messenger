plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "modules.module_payments"
    compileSdk = 34
}

dependencies {
    api(project(":libs:zeus"))
}
