package dev.tonimatas.packetfixer.mixins;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.Varint21FrameDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Varint21FrameDecoder.class)
public abstract class Varint21FrameDecoderMixin {
    @Unique
    private int packetFixer$varInt21Size = 10;

    @Inject(method = "decode", at = @At("HEAD"))
    private void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list, CallbackInfo ci) {
        packetFixer$varInt21Size = FriendlyByteBuf.getVarIntSize(byteBuf.readableBytes()) + 2;
    }

    @ModifyConstant(method = "decode", constant = @Constant(intValue = 3))
    private int newSize(int constant) {
        return packetFixer$varInt21Size;
    }
}
