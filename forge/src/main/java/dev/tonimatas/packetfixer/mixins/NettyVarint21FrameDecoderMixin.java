package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NettyVarint21FrameDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(NettyVarint21FrameDecoder.class)
public class NettyVarint21FrameDecoderMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 3))
    private int newSize$decode(int constant, ChannelHandlerContext p_decode_1_, ByteBuf p_decode_2_) {
        return newSize$getByteSize(p_decode_2_.readableBytes()) + 2;
    }
    
    @Unique
    private static int newSize$getByteSize(int data) {
        for(int i = 1; i < Config.getVarIntSize(); ++i) {
            if ((data & -1 << i * 7) == 0) {
                return i;
            }
        }

        return Config.getVarIntSize();
    }
}
