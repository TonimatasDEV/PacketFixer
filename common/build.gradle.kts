val fabricLoaderVersion: String by extra

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
}

architectury {
    common("fabric", "forge", "neoforge")
}

loom {
    accessWidenerPath.set(file("src/main/resources/cerium.accesswidener"))
}