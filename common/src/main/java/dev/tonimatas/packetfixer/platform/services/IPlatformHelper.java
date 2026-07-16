package dev.tonimatas.packetfixer.platform.services;

public interface IPlatformHelper {

    /**
     * Gets the name of the current platform
     *
     * @return The name of the current platform.
     */
    String getPlatformName();

    /**
     * Gets the version of Packet Fixer.
     *
     * @return The version of Packet Fixer.
     */
    String getModVersion();

    /**
     * Check if a mod is enabled or disabled.
     *
     * @return True for enabled and false for disabled
     */
    boolean isModEnabled(String id);
}
