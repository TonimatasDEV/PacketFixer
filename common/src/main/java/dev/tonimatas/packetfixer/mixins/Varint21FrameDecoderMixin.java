package dev.tonimatas.packetfixer.mixins;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.VarInt;
import net.minecraft.network.Varint21FrameDecoder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Varint21FrameDecoder.class)
public abstract class Varint21FrameDecoderMixin {
    @Mutable @Shadow @Final private ByteBuf helperBuf;

    @Inject(method = "decode", at = @At("HEAD"))
    private void init$helper(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list, CallbackInfo ci) {
        this.helperBuf = Unpooled.directBuffer(VarInt.getByteSize(byteBuf.readableBytes()) + 2);
    }

    @ModifyConstant(method = "copyVarint", constant = @Constant(intValue = 3))
    private static int newSize(int value, ByteBuf byteBuf) {
        return VarInt.getByteSize(byteBuf.readableBytes()) + 2;
    }
}