val fabricLoaderVersion: String by extra

architectury {
    common("fabric", "neoforge")
}

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
}
