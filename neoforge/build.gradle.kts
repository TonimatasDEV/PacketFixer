plugins {
    id("multiloader-loader")
    id("net.neoforged.moddev")
}

val minecraftVersion: String by extra
val neoforgeVersion: String by extra
val modVersion: String by extra

neoForge {
    version = neoforgeVersion
    
    runs {
        configureEach {
            systemProperty("neoforge.enabledGameTestNamespaces", "packetfixer")
        }

        create("client") {
            client()
        }

        create("data") {
            clientData()
        }

        create("server") {
            server()
        }
    }

    mods {
        create("packetfixer") {
            sourceSet(sourceSets.main.get())
        }
    }
}

sourceSets.main.get().resources { srcDir("src/generated/resources") }