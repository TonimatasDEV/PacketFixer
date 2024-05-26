val loaderVersion: String by extra

dependencies {
    modImplementation("net.fabricmc:fabric-loader:$loaderVersion")
}

architectury {
    common("forge", "fabric")
}