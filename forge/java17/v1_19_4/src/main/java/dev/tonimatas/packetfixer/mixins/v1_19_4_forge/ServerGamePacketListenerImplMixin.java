package dev.tonimatas.packetfixer.mixins.v1_19_4_forge;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {
    @ModifyConstant(method = "tick", constant = @Constant(longValue = 15000L))
    private long packetfixer$tick(long constant) {
        return Config.getTimeout() * 1000L;
    }
}
