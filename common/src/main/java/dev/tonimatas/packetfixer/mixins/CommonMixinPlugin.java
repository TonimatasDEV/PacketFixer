package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.platform.Services;
import dev.tonimatas.packetfixer.util.Config;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;

public class CommonMixinPlugin implements IMixinConfigPlugin {

    @Override
    public void onLoad(String mixinPackage) {
        Config.runProperties();

        if (Services.PLATFORM.getPlatformName().equalsIgnoreCase("neoforge")) {
            System.getProperties().setProperty("neoforge.disablePacketCompressionDebug", "true");
        }
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        boolean isKryptonHere = Services.PLATFORM.isModEnabled("krypton") || Services.PLATFORM.isModEnabled("krypton_fnp");

        if (mixinClassName.equalsIgnoreCase("dev.tonimatas.packetfixer.mixins.VarIntMixin")) {
            return !isKryptonHere;
        }

        return true;
    }
}
