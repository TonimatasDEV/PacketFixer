package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin({ServerGamePacketListenerImpl.class})
public class ServerGamePacketListenerImplMixin {

    @ModifyConstant(method = "tick", constant = @Constant(longValue = 15000L, ordinal = 0))
    private long injected(long value) {
        return value*4;
    }
}