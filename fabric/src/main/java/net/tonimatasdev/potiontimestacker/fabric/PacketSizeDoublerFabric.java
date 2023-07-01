package net.tonimatasdev.potiontimestacker.fabric;

import net.fabricmc.api.ModInitializer;
import net.tonimatasdev.packetsizedoubler.PacketSizeDoubler;

public class PacketSizeDoublerFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        PacketSizeDoubler.init();
    }
}