package dev.tonimatas.packetfixer.util;

public class MixinCheck {
    public static boolean with(String mixinClassName, String mixinName) {
        return mixinClassName.equals("dev.tonimatas.packetfixer.mixins." + mixinName);
    }
}
