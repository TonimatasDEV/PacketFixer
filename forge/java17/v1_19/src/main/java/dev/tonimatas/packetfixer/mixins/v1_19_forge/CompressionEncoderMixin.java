package dev.tonimatas.packetfixer.mixins.v1_19_forge;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.CompressionEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(CompressionEncoder.class)
public class CompressionEncoderMixin {
    @ModifyConstant(method = "encode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Lio/netty/buffer/ByteBuf;)V", constant = @Constant(intValue = 2097152))
    private int packetfixer$newSize(int value) {
        return Config.getDecoderSize();
    }
}
