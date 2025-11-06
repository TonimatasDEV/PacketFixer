package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(targets = "net.minecraft.server.network.ServerConnectionListener$1")
public class ServerConnectionListenerMixin {
    @ModifyConstant(method = "initChannel", constant = @Constant(intValue = 30))
    private static int packetfixer$newTimeout(int value) {
        return Config.getReadTimeout();
    }
}
