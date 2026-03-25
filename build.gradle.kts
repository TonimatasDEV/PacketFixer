plugins {
    // https://fabricmc.net/develop/
    id("net.fabricmc.fabric-loom") version "1.15-SNAPSHOT" apply false
    // https://projects.neoforged.net/neoforged/moddevgradle
    id("net.neoforged.moddev") version "2.0.141" apply false
}

tasks.register<DefaultTask>("export") {
    dependsOn(project(":fabric").tasks.named("remapJar"))
    dependsOn(project(":neoforge").tasks.named("jar"))
}
