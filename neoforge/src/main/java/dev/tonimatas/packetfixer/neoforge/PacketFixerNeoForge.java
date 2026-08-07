package dev.tonimatas.packetfixer.neoforge;


import dev.tonimatas.packetfixer.PacketFixer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(PacketFixer.MOD_ID)
public class PacketFixerNeoForge {
    @SuppressWarnings("unused")
    public PacketFixerNeoForge(IEventBus eventBus) {
        PacketFixer.init();
    }
}
