package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.nbt.NbtTagSizeTracker;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = NbtTagSizeTracker.class, priority = 999)
public abstract class NbtTagSizeTrackerMixin {
    @Redirect(method = "add", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtTagSizeTracker;maxBytes:J", opcode = Opcodes.GETFIELD))
    public long accountBits(NbtTagSizeTracker instance) {
        return 9223372036854775807;
    }
}
