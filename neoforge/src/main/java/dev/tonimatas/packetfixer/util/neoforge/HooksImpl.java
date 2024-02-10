package dev.tonimatas.packetfixer.util.neoforge;

import net.neoforged.fml.loading.FMLLoader;

@SuppressWarnings("unused")
public class HooksImpl {
    public static boolean isModLoaded(String modId) {
        return FMLLoader.getLoadingModList().getModFileById(modId) != null;
    }
}
