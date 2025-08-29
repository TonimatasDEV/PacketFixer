package dev.tonimatas.packetfixer.mixins.v1_20_5_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {
    @ModifyConstant(method = "tick", constant = @Constant(longValue = 60L))
    private long packetfixer$tick(long constant) {
        return Config.getTimeout();
    }
}
