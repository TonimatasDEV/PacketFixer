package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.NettyCompressionDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(NettyCompressionDecoder.class)
public class NettyCompressionDecoderMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 2097152))
    private int newSize$decode(int constant) {
        return Config.getDecoderSize();
    }
}
