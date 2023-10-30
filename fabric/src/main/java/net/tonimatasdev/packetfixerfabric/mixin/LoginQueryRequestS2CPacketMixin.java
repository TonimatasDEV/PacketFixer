package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.network.packet.s2c.login.LoginQueryRequestS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = LoginQueryRequestS2CPacket.class, priority = 9999)
public class LoginQueryRequestS2CPacketMixin {
    // <= 1.20.1
    @ModifyConstant(method = "<init>(Lnet/minecraft/network/PacketByteBuf;)V", constant = @Constant(intValue = 1048576))
    private static int newSize(int value) {
        return Integer.MAX_VALUE;
    }

    // 1.20.2
    //@ModifyConstant(method = "readUnknownPayload", constant = @Constant(intValue = 1048576))
    //private static int newSize(int value) {
    //    return Integer.MAX_VALUE;
    //}
}
