plugins {
    id("multiloader-loader")
    id("net.fabricmc.fabric-loom")
}

val minecraftVersion: String by extra
val fabricMinecraftVersionRange: String by extra
val fabricLoaderVersion: String by extra
val fabricVersion: String by extra

dependencies {
    minecraft("com.mojang:minecraft:${minecraftVersion}")
    implementation("net.fabricmc:fabric-loader:${fabricLoaderVersion}")
    implementation("net.fabricmc.fabric-api:fabric-api:${fabricVersion}")
}

loom {
    val aw = project(":common").file("src/main/resources/packetfixer.accesswidener")

    if (aw.exists()) {
        accessWidenerPath.set(aw)
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
