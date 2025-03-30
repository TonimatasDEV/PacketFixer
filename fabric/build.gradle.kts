@file:Suppress("UnstableApiUsage")

plugins {
    id("multiloader-loader")
    id("fabric-loom")
}

val minecraftVersion: String by extra
val fabricApiVersion: String by extra
val fabricLoaderVersion: String by extra
val modVersion: String by extra

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
    modImplementation("net.fabricmc.fabric-api:fabric-api:$fabricApiVersion+$minecraftVersion")
}

loom {
    mixin {
        defaultRefmapName.set("packetfixer.refmap.json")
    }

    runs {
        named("client") {
            client()
            configName = "Fabric Client"
            ideConfigGenerated(true)
            runDir("runs/client")
        }

        named("server") {
            server()
            configName = "Fabric Server"
            ideConfigGenerated(true)
            runDir("runs/server")
        }
    }
}
