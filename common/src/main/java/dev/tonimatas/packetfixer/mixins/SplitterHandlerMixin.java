package dev.tonimatas.packetfixer.mixins;

import net.minecraft.network.Varint21FrameDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Varint21FrameDecoder.class)
public class SplitterHandlerMixin {
    @ModifyConstant(method = "decode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Ljava/util/List;)V", constant = @Constant(intValue = 3))
    private int newSize(int value) {
        return 8;
    }
}
