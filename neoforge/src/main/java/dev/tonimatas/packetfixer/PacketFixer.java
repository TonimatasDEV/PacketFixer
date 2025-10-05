package dev.tonimatas.packetfixer;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(PacketFixerCommon.MOD_ID)
public class PacketFixer {
    @SuppressWarnings("unused")
    public PacketFixer(IEventBus eventBus) {
        PacketFixerCommon.init();
    }
}
