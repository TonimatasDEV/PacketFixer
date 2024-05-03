package dev.tonimatas.packetfixer.mixin;

import net.minecraft.network.packet.c2s.login.LoginQueryResponseC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = LoginQueryResponseC2SPacket.class, priority = 9999)
public class LoginQueryResponseC2SPacketMixin {
    @ModifyConstant(method = "read", constant = @Constant(intValue = 1048576))
    private int newSize(int value) {
        return Integer.MAX_VALUE;
    }
}
