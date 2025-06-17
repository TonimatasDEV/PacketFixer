plugins {
    id("dev.tonimatas.packetfixer.fabric")
}

dependencies {
    implementation(project(":fabric:java17:v1_18"))
    implementation(project(":fabric:java17:v1_19"))
}

loaderModPlugin {
    minecraftVersion = "1.20.1"
    javaVersion = JavaVersion.VERSION_17
    projects = listOf("v1_19")
}