package dev.tonimatas.packetfixer.mixins.v1_20_5_neoforge;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(FriendlyByteBuf.class)
public abstract class FriendlyByteBufMixin {
    @ModifyConstant(method = "readNbt(Lio/netty/buffer/ByteBuf;)Lnet/minecraft/nbt/CompoundTag;", constant = @Constant(longValue = 2097152L))
    private static long packetfixer$readNbt$newSize(long value) {
        return Config.getNbtMaxSize();
    }

    @ModifyConstant(method = "readUtf()Ljava/lang/String;", constant = @Constant(intValue = 32767))
    private int packetfixer$readUtf$newSize(int value) {
        return Config.getStringSize();
    }

    @ModifyConstant(method = "writeUtf(Ljava/lang/String;)Lnet/minecraft/network/FriendlyByteBuf;", constant = @Constant(intValue = 32767))
    private int packetfixer$writeUtf$newSize(int value) {
        return Config.getStringSize();
    }
}
