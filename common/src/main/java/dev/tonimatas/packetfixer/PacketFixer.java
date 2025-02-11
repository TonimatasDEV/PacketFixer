package dev.tonimatas.packetfixer;

import dev.tonimatas.packetfixer.util.Config;
import org.apache.logging.log4j.LogManager;

public class PacketFixer {
    public static void init() {
        LogManager.getLogger().info("PacketFixer has been initialized successfully.");
    }

	public static String getPayloadMessage() {
		return "Payload may not be larger than " + Config.getPacketSize() + " bytes. You can modify it in the Packet Fixer config.";
	}
}
