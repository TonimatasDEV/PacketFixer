package net.tonimatasdev.packetsizedoublerforge.mixin;

import net.minecraft.network.login.server.SCustomPayloadLoginPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(SCustomPayloadLoginPacket.class)
public class SCustomPayloadLoginPacketMixin {
    @ModifyConstant(method ="read", constant = @Constant(intValue = 1048576))
    private int packetDoubler(int value) {
        return value*10;
    }

}
