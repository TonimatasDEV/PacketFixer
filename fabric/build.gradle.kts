plugins {
    id("multiloader-loader")
    id("fabric-loom")
}

val minecraftVersion: String by extra
val parchmentMinecraft: String by extra
val parchmentVersion: String by extra
val fabricLoaderVersion: String by extra
val fabricVersion: String by extra

dependencies {
    minecraft("com.mojang:minecraft:${minecraftVersion}")

    mappings(loom.layered {
        officialMojangMappings()
        parchment("org.parchmentmc.data:parchment-${parchmentMinecraft}:${parchmentVersion}@zip")
    })

    modImplementation("net.fabricmc:fabric-loader:${fabricLoaderVersion}")
    modImplementation("net.fabricmc.fabric-api:fabric-api:${fabricVersion}")
}

loom {
    val aw = project(":common").file("src/main/resources/packetfixer.accesswidener")

    if (aw.exists()) {
        accessWidenerPath.set(aw)
    }

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
