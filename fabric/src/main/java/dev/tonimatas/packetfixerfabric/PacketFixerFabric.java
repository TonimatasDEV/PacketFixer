package dev.tonimatas.packetfixerfabric;

import dev.tonimatas.packetfixer.PacketFixer;
import net.fabricmc.api.ModInitializer;

public class PacketFixerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PacketFixer.init();
    }
}
