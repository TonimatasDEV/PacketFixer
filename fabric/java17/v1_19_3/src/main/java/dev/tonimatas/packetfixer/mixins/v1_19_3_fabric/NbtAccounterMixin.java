package dev.tonimatas.packetfixer.mixins.v1_19_3_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.nbt.NbtAccounter;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NbtAccounter.class)
public class NbtAccounterMixin {
    @Shadow @Final private long quota;

    @Redirect(method = "accountBytes", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtAccounter;quota:J"))
    private long packetfixer$newSize(NbtAccounter instance) {
        return Config.isForceUnlimitedNbtEnabled() ? Long.MAX_VALUE : quota;
    }
}
