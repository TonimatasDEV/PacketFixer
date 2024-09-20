pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven(url = "https://maven.minecraftforge.net/")
        maven(url = "https://repo.spongepowered.org/repository/maven-public/")
        maven(url = "https://maven.fabricmc.net/")
        maven(url = "https://nexus.gtnewhorizons.com/repository/public/")
    }
}

include("forge")
rootProject.name = "PacketFixer"
