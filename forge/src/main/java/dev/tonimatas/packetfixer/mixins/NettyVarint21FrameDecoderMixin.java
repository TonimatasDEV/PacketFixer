package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.NettyVarint21FrameDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = NettyVarint21FrameDecoder.class, priority = 9999)
public class NettyVarint21FrameDecoderMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 3))
    private int newSize$decode(int constant) {
        return Config.getVarInt21Size();
    }
}
