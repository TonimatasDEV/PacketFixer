package net.tonimatasdev.packetfixerforge;

import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;

@Mod("packetfixer")
public class PacketFixerNeoForge {
    public PacketFixerNeoForge() {
        LogUtils.getLogger().info("Packet Fixer (NeoForge) has been initialized successfully");
    }
}
