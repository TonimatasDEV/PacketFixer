package net.tonimatasdev.packetsizedoubler.mixin;

import net.minecraft.network.PacketEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = PacketEncoder.class, priority = 999)
public class PacketEncoderMixin {
    @ModifyConstant(method = "encode(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/protocol/Packet;Lio/netty/buffer/ByteBuf;)V", constant = @Constant(intValue = 8388608))
    private int newSize(int value) {
        return 2147483647;
    }
}
