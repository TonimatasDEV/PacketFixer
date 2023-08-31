package net.tonimatasdev.packetfixerforge.mixin;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.CompressionEncoder;
import net.minecraft.network.FriendlyByteBuf;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.zip.Deflater;

@Mixin(value = CompressionEncoder.class, priority = 9999)
public class CompressionEncoderMixin {
    @Shadow private int threshold;

    @Shadow @Final private static boolean DISABLE_PACKET_DEBUG;

    @Shadow @Final private static Logger LOGGER;

    @Shadow @Final private Deflater deflater;

    @Shadow @Final private byte[] encodeBuf;

    /**
     * @author TonimatasDEV
     * @reason Infinite packet size
     */
    @SuppressWarnings("PointlessBooleanExpression")
    @Overwrite
    protected void encode(ChannelHandlerContext p_129452_, ByteBuf p_129453_, ByteBuf p_129454_) {
        int i = p_129453_.readableBytes();
        FriendlyByteBuf friendlybytebuf = new FriendlyByteBuf(p_129454_);
        if (i < this.threshold) {
            friendlybytebuf.writeVarInt(0);
            friendlybytebuf.writeBytes(p_129453_);
        } else {
            if (!DISABLE_PACKET_DEBUG && i > net.minecraft.network.CompressionDecoder.MAXIMUM_UNCOMPRESSED_LENGTH || true) {
                p_129453_.markReaderIndex();
                LOGGER.error("Attempted to send packet over maximum protocol size: {} > {}\nData:\n{}", i, net.minecraft.network.CompressionDecoder.MAXIMUM_UNCOMPRESSED_LENGTH,
                        net.minecraftforge.logging.PacketDump.getContentDump(p_129453_));
                p_129453_.resetReaderIndex();
            }
            byte[] abyte = new byte[i];
            p_129453_.readBytes(abyte);
            friendlybytebuf.writeVarInt(abyte.length);
            this.deflater.setInput(abyte, 0, i);
            this.deflater.finish();

            while(!this.deflater.finished()) {
                int j = this.deflater.deflate(this.encodeBuf);
                friendlybytebuf.writeBytes(this.encodeBuf, 0, j);
            }

            this.deflater.reset();
        }
    }
}
