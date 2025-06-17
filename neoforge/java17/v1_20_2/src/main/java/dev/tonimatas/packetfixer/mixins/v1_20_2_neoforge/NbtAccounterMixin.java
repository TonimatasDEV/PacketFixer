package dev.tonimatas.packetfixer.mixins.v1_20_2_neoforge;

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

    @Redirect(method = "accountBytes(J)V", at = @At(value = "FIELD", target = "Lnet/minecraft/nbt/NbtAccounter;quota:J"))
    private long packetfixer$newSize(NbtAccounter instance) {
        return Config.isForceUnlimitedNbtEnabled() ? Config.getNbtMaxSize() : quota;
    }
}
