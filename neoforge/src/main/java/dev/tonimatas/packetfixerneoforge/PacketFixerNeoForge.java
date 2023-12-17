package dev.tonimatas.packetfixerneoforge;

import dev.tonimatas.packetfixer.PacketFixer;
import net.neoforged.fml.common.Mod;

@Mod(PacketFixer.MOD_ID)
public class PacketFixerNeoForge {
    public PacketFixerNeoForge() {
        PacketFixer.init();
    }
}
