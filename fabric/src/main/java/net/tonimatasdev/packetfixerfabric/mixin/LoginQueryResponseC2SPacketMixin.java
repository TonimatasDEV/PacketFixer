package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.login.LoginQueryResponseC2SPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = LoginQueryResponseC2SPacket.class, priority = 9999)
public class LoginQueryResponseC2SPacketMixin {
    // <= 1.20.1
    @ModifyVariable(method = "<init>(Lnet/minecraft/network/PacketByteBuf;)V", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/network/PacketByteBuf;readNullable(Lnet/minecraft/network/PacketByteBuf$PacketReader;)Ljava/lang/Object;"), index = 1, argsOnly = true)
    private PacketByteBuf redirectReadNullable(PacketByteBuf value) {
        return new PacketByteBuf(value.readBytes(value.readableBytes()));
    }


    // 1.20.2
    //@ModifyConstant(method = "getVanillaPayload", constant = @Constant(intValue = 1048576))
    //private static int newSize(int value) {
    //    return Integer.MAX_VALUE;
    //}
}
