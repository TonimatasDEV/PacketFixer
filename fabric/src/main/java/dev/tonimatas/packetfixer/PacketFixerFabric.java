package dev.tonimatas.packetfixer;

import net.fabricmc.api.ModInitializer;

public class PacketFixerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PacketFixer.init();
    }
}
