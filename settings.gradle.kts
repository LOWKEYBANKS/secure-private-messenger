pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "secure-private-messenger"

include(":app")

include(":libs:libsodium")
include(":libs:livekit:livekit-android-sdk")
include(":libs:tor")
include(":libs:briar")
include(":libs:zeus")

include(":modules:core-crypto")
include(":modules:module-livekit")
include(":modules:module-payments")
include(":modules:core-briar")
include(":modules:ui")

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

include(
    ":app",
    ":libs:libsodium", 
    ":libs:tor",
    ":libs:livekit:livekit-android-sdk",
    ":modules:core-crypto",
    ":modules:module-livekit",
    ":modules:module-payments"
)

rootProject.name = "secure-private-messenger"
