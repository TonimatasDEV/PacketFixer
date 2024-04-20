package dev.tonimatas.packetfixer.mixins;

import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = FriendlyByteBuf.class, priority = 9999)
public abstract class FriendlyByteBufMixin {
    @ModifyConstant(method = "readNbt()Lnet/minecraft/nbt/CompoundTag;", constant = @Constant(longValue = 2097152L))
    public long newSize(long value) {
        return Long.MAX_VALUE;
    }
}
