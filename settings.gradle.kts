pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://maven.minecraftforge.net/")
        maven(url = "https://maven.architectury.dev/")
        maven(url = "https://maven.fabricmc.net/")
    }
}

include("common", "fabric", "forge")
rootProject.name = "PacketFixer"
