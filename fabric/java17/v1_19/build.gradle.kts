plugins {
    id("dev.tonimatas.packetfixer.fabric")
}

dependencies {
    implementation(project(":fabric:java17:v1_18"))
}

loaderModPlugin {
    minecraftVersion = "1.19.2"
    javaVersion = JavaVersion.VERSION_17
    projects = listOf("v1_18")
}
