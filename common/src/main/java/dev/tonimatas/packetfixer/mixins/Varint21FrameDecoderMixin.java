package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.network.BandwidthDebugMonitor;
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

@Mixin(Varint21FrameDecoder.class)
public abstract class Varint21FrameDecoderMixin {
    @Mutable @Shadow @Final private ByteBuf helperBuf;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init$helper(BandwidthDebugMonitor bandwidthDebugMonitor, CallbackInfo ci) {
        this.helperBuf = Unpooled.directBuffer(Config.getVarInt21Size());
    }
    
    @ModifyConstant(method = "copyVarint", constant = @Constant(intValue = 3))
    private static int newSize(int original) {
        return Config.getVarInt21Size();
    }
}