package net.tonimatasdev.packetfixerfabric;

import net.fabricmc.api.ModInitializer;
import net.tonimatasdev.packetfixer.PacketFixer;

public class PacketFixerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PacketFixer.init();
    }
}
