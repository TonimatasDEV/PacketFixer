package dev.tonimatas.packetfixer.mixins;

import net.minecraft.network.CompressionDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = CompressionDecoder.class, priority = 999)
public class CompressionDecoderMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 2097152), require = 0)
    private int newSize(int value) {
        return value * 100;
    }
}