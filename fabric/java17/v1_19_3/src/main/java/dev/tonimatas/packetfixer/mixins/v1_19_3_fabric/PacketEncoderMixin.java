package dev.tonimatas.packetfixer.mixins.v1_19_3_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.PacketEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(PacketEncoder.class)
public class PacketEncoderMixin {
    @ModifyConstant(method = "encode(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/protocol/Packet;Lio/netty/buffer/ByteBuf;)V", constant = @Constant(intValue = 8388608))
    private int packetfixer$newSize(int value) {
        return Config.getDecoderSize();
    }
}
