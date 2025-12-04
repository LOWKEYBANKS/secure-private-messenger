pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.
                    
                        ƒ
                        FAIL ON PROJECT REPOS
                    
                )
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "secure-private-messenger"

include(":app")

// Library modules
include(":libs:libsodium")
include(":libs:livekit:livekit-android-sdk")
include(":libs:tor")
include(":libs:briar")
include(":libs:zeus")

// Feature modules  
include(":modules:core-crypto")
include(":modules:module-livekit")
include(":modules:module-payments")
include(":modules:core-briar")
include(":modules:ui")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

