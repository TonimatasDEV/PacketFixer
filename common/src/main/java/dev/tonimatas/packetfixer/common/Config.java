package dev.tonimatas.packetfixer.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class Config {
    private static boolean allSizesUnlimited = true;
    private static long nbtMaxSize = 2097152;
    private static int packetSize = 1048576;
    private static int decoderSize = 8388608;
    private static int varInt21 = 3;
    private static int varInt = 5;
    private static int varLong = 10;
    private static int stringSize = 32767;
    private static int chunkPacketData = 2097152;
    private static int timeout = 90;
    private static boolean forceUnlimitedNbtEnabled = false;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void runProperties() {
        try {
            File configFolder = new File("config");

            if (!configFolder.exists()) {
                configFolder.mkdirs();
            }

            File propertiesFile = new File(configFolder, "packetfixer.properties");
            Properties properties = new Properties();

            if (!propertiesFile.exists()) {
                propertiesFile.createNewFile();
            }

            properties.load(Files.newInputStream(propertiesFile.toPath()));

            allSizesUnlimited = Boolean.parseBoolean(checkVariable(properties, "allSizesUnlimited", String.valueOf(allSizesUnlimited)));
            nbtMaxSize = Long.parseLong(checkVariable(properties, "nbtMaxSize", String.valueOf(nbtMaxSize)));
            packetSize = Integer.parseInt(checkVariable(properties, "packetSize", Integer.toString(packetSize)));
            decoderSize = Integer.parseInt(checkVariable(properties, "decoderSize", Integer.toString(decoderSize)));
            varInt21 = Integer.parseInt(checkVariable(properties, "varInt21", Integer.toString(varInt21)));
            varInt = Integer.parseInt(checkVariable(properties, "varInt", Integer.toString(varInt)));
            varLong = Integer.parseInt(checkVariable(properties, "varLong", Integer.toString(varLong)));
            stringSize = Integer.parseInt(checkVariable(properties, "stringSize", Integer.toString(stringSize)));
            chunkPacketData = Integer.parseInt(checkVariable(properties, "chunkPacketData", Integer.toString(chunkPacketData)));
            timeout = Integer.parseInt(checkVariable(properties, "timeout", Integer.toString(timeout)));
            forceUnlimitedNbtEnabled = Boolean.parseBoolean(checkVariable(properties, "forceUnlimitedNbtEnabled", Boolean.toString(forceUnlimitedNbtEnabled)));
            save(properties, propertiesFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static long getNbtMaxSize() {
        return allSizesUnlimited ? Long.MAX_VALUE : nbtMaxSize;
    }

    public static int getPacketSize() {
        return allSizesUnlimited ? Integer.MAX_VALUE : packetSize;
    }

    public static int getDecoderSize() {
        return allSizesUnlimited ? Integer.MAX_VALUE : decoderSize;
    }

    public static int getVarInt21Size() {
        return allSizesUnlimited ? Integer.MAX_VALUE : varInt21;
    }

    public static int getVarIntSize() {
        return allSizesUnlimited ? (Integer.MAX_VALUE / 2 - 1) : varInt;
    }
    
    public static int getVarLong() {
        return allSizesUnlimited ? (Integer.MAX_VALUE / 2 - 1) : varLong;
    }
    
    public static int getStringSize() {
        return allSizesUnlimited ? 327670000 : stringSize;
    }
    
    public static int getChunkPacketData() {
        return allSizesUnlimited ? Integer.MAX_VALUE : chunkPacketData;
    }
    
    public static int getTimeout() {
        return timeout;
    }
    
    public static boolean isForceUnlimitedNbtEnabled() {
        return forceUnlimitedNbtEnabled;
    }

    private static String checkVariable(Properties properties, String variable, String defaultValue) {
        if (properties.getProperty(variable) == null) {
            properties.setProperty(variable, defaultValue);
        }
        
        return properties.getProperty(variable);
    }

    private static void save(Properties properties, File propertiesFile) throws IOException {
        properties.store(Files.newOutputStream(propertiesFile.toPath()),
                "Packet Fixer config file.\n" +
                        "Default values (minecraft default): nbtMaxSize 2097152, packetSize 1048576, decoderSize 8388608 and varInt21Size 3.\n" +
                        "Max values are " + Integer.MAX_VALUE + " for packetSize/decoderSize/varInt21 and " + Long.MAX_VALUE + " for nbtMaxSize.");
    }
}
