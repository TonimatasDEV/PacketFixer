package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.VarLong;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(VarLong.class)
public class VarLongMixin {
    @ModifyConstant(method = "getByteSize", constant = @Constant(intValue = 10))
    private static int getByteSize$size(int value) {
        return Config.getVarLong();
    }
    
    @ModifyConstant(method = "read", constant = @Constant(intValue = 10))
    private static int read$size(int constant) {
        return Config.getVarLong();
    }

    @ModifyConstant(method = "read", constant = @Constant(stringValue = "VarLong too big"))
    private static String read$size(String constant) {
        return "VarInt too big. Packet Fixer configured to " + Config.getVarLong() + ". You can modify it in the Packet Fixer config.";
    }
}
