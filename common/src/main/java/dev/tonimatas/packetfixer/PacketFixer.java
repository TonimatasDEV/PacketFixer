package dev.tonimatas.packetfixer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PacketFixer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "packetfixer";

	public static void init() {
		LOGGER.info("Packet Fixer has been initialized successfully");
	}
}
