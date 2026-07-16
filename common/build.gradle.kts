val fabricLoaderVersion: String by extra

dependencies {
    implementation("net.fabricmc:fabric-loader:$fabricLoaderVersion")
}

architectury {
    common("fabric", "neoforge")
}