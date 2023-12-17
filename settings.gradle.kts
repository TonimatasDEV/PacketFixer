pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://maven.minecraftforge.net/")
        maven(url = "https://maven.architectury.dev/")
        maven(url = "https://maven.fabricmc.net/")
        maven(url = "https://maven.neoforged.net/releases")
    }
}

include("common", "fabric", "forge", "neoforge")
rootProject.name = "PacketFixer"
