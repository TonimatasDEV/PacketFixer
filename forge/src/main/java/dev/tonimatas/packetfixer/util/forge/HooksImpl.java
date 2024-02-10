package dev.tonimatas.packetfixer.util.forge;

import net.minecraftforge.fml.loading.FMLLoader;

@SuppressWarnings("unused")
public class HooksImpl {
    public static boolean isModLoaded(String modId) {
        return FMLLoader.getLoadingModList().getModFileById(modId) != null;
    }
}
