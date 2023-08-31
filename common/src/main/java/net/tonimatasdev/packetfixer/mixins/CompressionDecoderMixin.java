package net.tonimatasdev.packetfixer.mixins;

import net.minecraft.network.CompressionDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CompressionDecoder.class, priority = 999)
public class CompressionDecoderMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 8388608))
    private int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}