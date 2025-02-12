package dev.tonimatas.packetfixer.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class Config {
    private static Properties properties = null;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void runProperties() {
        try {
            File configFolder = new File("config");

            if (!configFolder.exists()) {
                configFolder.mkdirs();
            }

            File propertiesFile = new File(configFolder, "packetfixer.properties");
            properties = new Properties();

            if (!propertiesFile.exists()) {
                propertiesFile.createNewFile();
                
                properties.setProperty("allSizesUnlimited", "true");
                properties.setProperty("nbtMaxSize", Long.toString(2097152));
                properties.setProperty("packetSize", Integer.toString(1048576));
                properties.setProperty("decoderSize", Integer.toString(8388608));
                properties.setProperty("varInt21", Integer.toString(3));
                properties.setProperty("varInt", Integer.toString(5));
                properties.setProperty("varLong", Integer.toString(10));
                checkVariable("chunkPacketData", Integer.toString(2097152));
                properties.setProperty("timeout", Integer.toString(90));

                save(propertiesFile);
            }

            properties.load(Files.newInputStream(propertiesFile.toPath()));

            checkVariable("allSizesUnlimited", "true");
            checkVariable("nbtMaxSize", Long.toString(2097152));
            checkVariable("packetSize", Integer.toString(1048576));
            checkVariable("decoderSize", Integer.toString(8388608));
            checkVariable("varInt21", Integer.toString(3));
            checkVariable("varInt", Integer.toString(5));
            checkVariable("varLong", Integer.toString(10));
            checkVariable("chunkPacketData", Integer.toString(2097152));
            checkVariable("timeout", Integer.toString(90));
            save(propertiesFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean getUnlimitedPacketSize() {
        if (properties == null) runProperties();
        return Boolean.parseBoolean(properties.getProperty("allSizesUnlimited"));
    }

    public static long getNbtMaxSize() {
        if (properties == null) runProperties();
        return getUnlimitedPacketSize() ? Long.MAX_VALUE : Long.parseLong(properties.getProperty("nbtMaxSize"));
    }

    public static int getPacketSize() {
        if (properties == null) runProperties();
        return getUnlimitedPacketSize() ? Integer.MAX_VALUE : Integer.parseInt(properties.getProperty("packetSize"));
    }

    public static int getDecoderSize() {
        if (properties == null) runProperties();
        return getUnlimitedPacketSize() ? Integer.MAX_VALUE : Integer.parseInt(properties.getProperty("decoderSize"));
    }

    public static int getVarInt21Size() {
        if (properties == null) runProperties();
        return getUnlimitedPacketSize() ? (Integer.MAX_VALUE / 2 - 1) : Integer.parseInt(properties.getProperty("varInt21"));
    }

    public static int getVarIntSize() {
        if (properties == null) runProperties();
        return getUnlimitedPacketSize() ? (Integer.MAX_VALUE / 2 - 1) : Integer.parseInt(properties.getProperty("varInt"));
    }
    
    public static int getVarLong() {
        if (properties == null) runProperties();
        return getUnlimitedPacketSize() ? (Integer.MAX_VALUE / 2 - 1) : Integer.parseInt(properties.getProperty("varLong"));
    }
    
    public static int getChunkPacketData() {
        if (properties == null) runProperties();
        return getUnlimitedPacketSize() ? Integer.MAX_VALUE : Integer.parseInt(properties.getProperty("chunkPacketData"));
    }
    
    public static int getTimeout() {
        if (properties == null) runProperties();
        return Integer.parseInt(properties.getProperty("timeout"));
    }

    private static void checkVariable(String variable, String defaultValue) {
        if (properties.getProperty(variable) == null) {
            properties.setProperty(variable, defaultValue);
        }
    }

    private static void save(File propertiesFile) throws IOException {
        properties.store(Files.newOutputStream(propertiesFile.toPath()),
                "Packet Fixer config file.\n" +
                        "Default values (minecraft default): nbtMaxSize 2097152, packetSize 1048576, decoderSize 8388608 and varInt21Size 3.\n" +
                        "Max values are " + Integer.MAX_VALUE + " for packetSize/decoderSize/varInt21 and " + Long.MAX_VALUE + " for nbtMaxSize.");
    }
}
