package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.nbt.NBTSizeTracker;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NBTSizeTracker.class)
public class NBTSizeTrackerMixin {
    @Shadow @Final private long max;

    @Redirect(method = "read", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NBTSizeTracker;max:J", opcode = Opcodes.GETFIELD))
    private long read(NBTSizeTracker instance) {
        return Math.max(Config.getNbtMaxSize(), max);
    }
}
