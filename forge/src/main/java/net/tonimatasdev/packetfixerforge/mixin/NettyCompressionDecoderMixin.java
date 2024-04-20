package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.network.NettyCompressionDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = NettyCompressionDecoder.class, priority = 999)
public class NettyCompressionDecoderMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 2097152), require = 0)
    private int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}