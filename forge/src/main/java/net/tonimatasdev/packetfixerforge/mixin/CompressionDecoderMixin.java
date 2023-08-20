package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.network.CompressionDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = CompressionDecoder.class, priority = 999)
public class CompressionDecoderMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 8388608), require = 0)
    private int newSize(int value) {
        return value * 100;
    }
}