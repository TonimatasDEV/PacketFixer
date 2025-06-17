package dev.tonimatas.packetfixer.fabric;

import dev.tonimatas.packetfixer.LoaderExtension;

public class FabricLoaderExtension extends LoaderExtension {
    private String fabricVersion;

    public String getFabricVersion() {
        return fabricVersion;
    }

    public void setFabricVersion(String fabricVersion) {
        this.fabricVersion = fabricVersion;
    }
}
