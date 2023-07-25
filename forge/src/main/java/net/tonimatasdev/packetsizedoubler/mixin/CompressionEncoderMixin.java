package net.tonimatasdev.packetsizedoubler.mixin;

import com.mojang.logging.LogUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.CompressionDecoder;
import net.minecraft.network.CompressionEncoder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.logging.PacketDump;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.zip.Deflater;

@Mixin(value = CompressionEncoder.class, priority = 999)
public class CompressionEncoderMixin {
    @Shadow private int threshold;
    @Shadow @Final private Deflater deflater;
    @Shadow @Final private byte[] encodeBuf;

    /**
     * @author TonimatasDEV
     * @reason Fix problems when using many mods
     */
    @SuppressWarnings("PointlessBooleanExpression")
    @Overwrite
    protected void encode(ChannelHandlerContext p_129452_, ByteBuf p_129453_, ByteBuf p_129454_) {
        int i = p_129453_.readableBytes();
        FriendlyByteBuf friendlybytebuf = new FriendlyByteBuf(p_129454_);
        if (i < threshold) {
            friendlybytebuf.writeVarInt(0);
            friendlybytebuf.writeBytes(p_129453_);
        } else {
            if (i > CompressionDecoder.MAXIMUM_UNCOMPRESSED_LENGTH || false) {
                p_129453_.markReaderIndex();
                LogUtils.getLogger().error("Attempted to send packet over maximum protocol size: {} > {}\nData:\n{}", i, CompressionDecoder.MAXIMUM_UNCOMPRESSED_LENGTH,
                        PacketDump.getContentDump(p_129453_));
                p_129453_.resetReaderIndex();
            }
            byte[] abyte = new byte[i];
            p_129453_.readBytes(abyte);
            friendlybytebuf.writeVarInt(abyte.length);
            deflater.setInput(abyte, 0, i);
            deflater.finish();

            while(!deflater.finished()) {
                int j = deflater.deflate(encodeBuf);
                friendlybytebuf.writeBytes(encodeBuf, 0, j);
            }

            deflater.reset();
        }

    }
}
