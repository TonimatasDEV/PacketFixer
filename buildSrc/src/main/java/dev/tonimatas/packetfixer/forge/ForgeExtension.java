package dev.tonimatas.packetfixer.forge;

import dev.tonimatas.packetfixer.LoaderExtension;

public class ForgeExtension extends LoaderExtension {
    private String forgeVersion;

    public String getForgeVersion() {
        return forgeVersion;
    }

    public void setForgeVersion(String forgeVersion) {
        this.forgeVersion = forgeVersion;
    }
}
