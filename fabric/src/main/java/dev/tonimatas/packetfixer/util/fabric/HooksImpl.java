package dev.tonimatas.packetfixer.util.fabric;

import net.fabricmc.loader.api.FabricLoader;

@SuppressWarnings("unused")
public class HooksImpl {
    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
