package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.network.NettyVarint21FrameDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = NettyVarint21FrameDecoder.class, priority = 9999)
public class NettyVarint21FrameDecoderMixin {
    @ModifyConstant(method = "decode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Ljava/util/List;)V", constant = @Constant(intValue = 3))
    private int newSize(int value) {
        return 8;
    }
}
