package dev.tonimatas.packetfixer.fabric;

import dev.tonimatas.packetfixer.PacketFixer;
import net.fabricmc.api.ModInitializer;

public class PacketFixerFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        PacketFixer.init();
    }
}
