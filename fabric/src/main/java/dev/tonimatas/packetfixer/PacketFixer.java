package dev.tonimatas.packetfixer;

import net.fabricmc.api.ModInitializer;

public class PacketFixer implements ModInitializer {

    @Override
    public void onInitialize() {
        PacketFixerCommon.init();
    }
}
