package net.tonimatasdev.packetfixerfabric;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;

public class PacketFixerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        LogManager.getLogger().info("Packet Fixer (Fabric) has been initialized successfully");
    }
}
