package dev.tonimatas.packetfixer.platform;

import dev.tonimatas.packetfixer.platform.services.IPlatformHelper;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public String getModVersion() {
        return FMLLoader.getCurrent().getLoadingModList().getModFileById("packetfixer").versionString();
    }
}
