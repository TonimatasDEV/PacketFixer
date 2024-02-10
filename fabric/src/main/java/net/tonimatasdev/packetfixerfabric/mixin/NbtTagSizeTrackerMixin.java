package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.nbt.NbtTagSizeTracker;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NbtTagSizeTracker.class, priority = 9999)
public abstract class NbtTagSizeTrackerMixin {
    @Redirect(method = "add(J)V", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtTagSizeTracker;maxBytes:J", opcode = Opcodes.GETFIELD))
    public long newSize(NbtTagSizeTracker instance) {
        return Long.MAX_VALUE;
    }
}
