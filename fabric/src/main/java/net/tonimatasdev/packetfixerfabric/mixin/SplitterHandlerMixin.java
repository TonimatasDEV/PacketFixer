package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.network.SplitterHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SplitterHandler.class)
public class SplitterHandlerMixin {
    @ModifyConstant(method = "decode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Ljava/util/List;)V", constant = @Constant(intValue = 3))
    private int newSize(int value) {
        return 8;
    }
}
