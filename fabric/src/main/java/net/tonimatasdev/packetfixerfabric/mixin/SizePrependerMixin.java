package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.network.SizePrepender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SizePrepender.class)
public class SizePrependerMixin {
    @ModifyConstant(method = "encode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Lio/netty/buffer/ByteBuf;)V", constant = @Constant(intValue = 3))
    private int newSize(int value) {
        return 8;
    }
}
