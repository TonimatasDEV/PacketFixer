package net.tonimatasdev.packetfixerfabric;

import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;

public class PacketFixerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LogUtils.getLogger().info("PacketFixer (Fabric) has been initialized successfully");
    }
}