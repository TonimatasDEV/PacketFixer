plugins {
    // https://fabricmc.net/develop/
    id("fabric-loom") version "1.11-SNAPSHOT" apply false
    // https://projects.neoforged.net/neoforged/moddevgradle
    id("net.neoforged.moddev") version "2.0.115" apply false
}

tasks.register<DefaultTask>("export") {
    dependsOn(project(":fabric").tasks.named("remapJar"))
    dependsOn(project(":neoforge").tasks.named("jar"))
}
