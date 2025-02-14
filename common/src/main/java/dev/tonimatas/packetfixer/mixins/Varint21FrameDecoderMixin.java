package dev.tonimatas.packetfixer.mixins;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.network.VarInt;
import net.minecraft.network.Varint21FrameDecoder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(Varint21FrameDecoder.class)
public abstract class Varint21FrameDecoderMixin {
    @Mutable @Shadow @Final private ByteBuf helperBuf;

    @Redirect(method = "decode", at = @At(value = "INVOKE", target = "Lio/netty/buffer/ByteBuf;markReaderIndex()Lio/netty/buffer/ByteBuf;"))
    private ByteBuf init$helper(ByteBuf instance) {
        instance.markReaderIndex();
        this.helperBuf = Unpooled.directBuffer(VarInt.getByteSize(instance.readableBytes()) + 2);
        return instance;
    }

    @ModifyConstant(method = "copyVarint", constant = @Constant(intValue = 3))
    private static int newSize(int value, ByteBuf byteBuf) {
        return VarInt.getByteSize(byteBuf.readableBytes()) + 2;
    }
}