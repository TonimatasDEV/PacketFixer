package dev.tonimatas.packetfixer.mixins;

import net.minecraft.network.Varint21FrameDecoder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Varint21FrameDecoder.class)
public class Varint21FrameDecoderMixin {
    @ModifyConstant(method = "decode", constant = @Constant(intValue = 3))
    private static int newSize(int value) {
        return 8;
    }
}