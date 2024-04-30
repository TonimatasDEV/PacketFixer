val fabricLoaderVersion: String by extra

architectury {
    common("fabric", "forge", "neoforge")
}

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
}
