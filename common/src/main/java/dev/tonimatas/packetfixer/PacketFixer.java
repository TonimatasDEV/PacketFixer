package dev.tonimatas.packetfixer;

import com.mojang.logging.LogUtils;
import dev.tonimatas.packetfixer.util.Config;

public class PacketFixer {
	public static final String MOD_ID = "packetfixer";

	public static void init() {
		LogUtils.getLogger().info("Packet Fixer has been initialized successfully");
	}
    
    public static String getPayloadMessage() {
        return "Payload may not be larger than " + Config.getPacketSize() + " bytes. You can modify it in the Packet Fixer config.";
    }
}
