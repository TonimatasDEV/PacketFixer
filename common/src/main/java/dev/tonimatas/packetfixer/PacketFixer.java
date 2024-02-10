package dev.tonimatas.packetfixer;

import com.mojang.logging.LogUtils;
public class PacketFixer {
	public static final String MOD_ID = "packetfixer";

	public static void init() {
		LogUtils.getLogger().info("Packet Fixer has been initialized successfully");
	}
}
