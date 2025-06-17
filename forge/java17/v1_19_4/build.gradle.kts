plugins {
    id("dev.tonimatas.packetfixer.forge")
}

dependencies {
    implementation(project(":forge:java17:v1_18"))
    implementation(project(":forge:java17:v1_19"))
    implementation(project(":forge:java17:v1_19_3"))
}

loaderModPlugin {
    minecraftVersion = "1.20.1"
    forgeVersion = "47.4.2"
    javaVersion = JavaVersion.VERSION_17
    projects = listOf("v1_19_3")
}
