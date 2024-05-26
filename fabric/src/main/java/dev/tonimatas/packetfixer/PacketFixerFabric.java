package dev.tonimatas.packetfixer;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;

public class PacketFixerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PacketFixer.init();
    }
}
