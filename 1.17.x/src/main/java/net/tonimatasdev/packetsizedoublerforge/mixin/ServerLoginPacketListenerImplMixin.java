package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.server.network.ServerLoginPacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerLoginPacketListenerImpl.class)
public class ServerLoginPacketListenerImplMixin {

    @ModifyConstant(method = "tick", constant = @Constant(intValue = 600))
    private int packetDoubler(int value) {
        return value*10;
    }
}
