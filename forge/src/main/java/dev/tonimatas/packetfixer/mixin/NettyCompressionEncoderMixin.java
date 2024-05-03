package dev.tonimatas.packetfixer.mixin;

import net.minecraft.network.NettyCompressionEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = NettyCompressionEncoder.class, priority = 999)
public class NettyCompressionEncoderMixin {
    @ModifyConstant(method = "encode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Lio/netty/buffer/ByteBuf;)V", constant = @Constant(intValue = 2097152))
    private int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}
