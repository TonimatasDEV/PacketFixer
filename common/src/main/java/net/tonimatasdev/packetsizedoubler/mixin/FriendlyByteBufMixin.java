package net.tonimatasdev.packetsizedoubler.mixin;

import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = FriendlyByteBuf.class, priority = 999)
public class FriendlyByteBufMixin {
    @ModifyConstant(method = {"readNbt()Lnet/minecraft/nbt/CompoundTag;"}, constant = {@Constant(longValue = 2097152L)})
    private long newSize(long value) {
        return value * 100;
    }
}
