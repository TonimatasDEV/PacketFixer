plugins {
    id("dev.tonimatas.packetfixer.forge")
}

dependencies {
    implementation(project(":forge:java17:v1_18"))
    implementation(project(":forge:java17:v1_19"))
}

loaderModPlugin {
    minecraftVersion = "1.19.3"
    forgeVersion = "44.1.23"
    javaVersion = JavaVersion.VERSION_17
    projects = listOf("v1_19")
}