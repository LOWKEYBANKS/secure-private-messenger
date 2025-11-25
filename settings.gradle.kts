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
