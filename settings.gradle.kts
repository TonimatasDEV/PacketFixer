pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://maven.neoforged.net/")
        maven(url = "https://maven.architectury.dev/")
        maven(url = "https://maven.fabricmc.net/")
    }
}

include("common", "fabric", "neoforge")
rootProject.name = "PacketFixer"
