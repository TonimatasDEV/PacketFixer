val fabricLoaderVersion: String by extra

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
}

architectury {
    common("fabric", "forge")
}
