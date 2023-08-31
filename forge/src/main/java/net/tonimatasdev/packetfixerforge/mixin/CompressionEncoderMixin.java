package net.tonimatasdev.packetfixerforge.mixin;

import net.minecraft.network.CompressionEncoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = CompressionEncoder.class, priority = 9999)
public class CompressionEncoderMixin {
    @Redirect(method = "encode(Lio/netty/channel/ChannelHandlerContext;Lio/netty/buffer/ByteBuf;Lio/netty/buffer/ByteBuf;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/network/CompressionEncoder;DISABLE_PACKET_DEBUG:Z"))
    public boolean injected() {
        return true;
    }
}
