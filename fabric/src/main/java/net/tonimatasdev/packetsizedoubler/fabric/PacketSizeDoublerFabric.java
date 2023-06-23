package net.tonimatasdev.packetsizedoubler.fabric;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;

public class PacketSizeDoublerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LogUtils.getLogger().info("PacketSizeDoubler (Fabric) has been initialized successfully");
    }
}