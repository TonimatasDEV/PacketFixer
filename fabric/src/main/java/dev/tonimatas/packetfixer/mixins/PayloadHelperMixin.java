package dev.tonimatas.packetfixer.mixins;

import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.fabricmc.fabric.impl.networking.payload.PayloadHelper")
public class PayloadHelperMixin {
    @Inject(method = "assertSize", at = @At("HEAD"), cancellable = true)
    private static void newSize$assertSize(FriendlyByteBuf buf, int maxSize, CallbackInfo ci) {
        ci.cancel();
    }
}
