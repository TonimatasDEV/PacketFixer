package net.tonimatasdev.packetfixerforge;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;

@Mod("packetfixer")
public class PacketFixerForge {
    public PacketFixerForge() {
        LogUtils.getLogger().info("Packet Fixer (Forge) has been initialized successfully");
    }
}
