import org.gradle.internal.extensions.stdlib.capitalized

plugins {
    id("multiloader-loader")
    id("net.neoforged.moddev")
}

val neoforgeVersion: String by extra
val parchmentMinecraft: String by extra
val parchmentVersion: String by extra

neoForge {
    version = neoforgeVersion
    val at = project(":common").file("src/main/resources/META-INF/accesstransformer.cfg")

    if (at.exists()) {
        accessTransformers.from(at.absolutePath)
    }

    runs {
        configureEach {
            systemProperty("neoforge.enabledGameTestNamespaces", "packetfixer")
            ideName = "NeoForge ${this.name.capitalized()} (${project.path})" // Unify the run config names with fabric
        }

        create("client") {
            client()
        }

        create("clientData") {
            clientData()
        }

        create("serverData") {
            serverData()
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
