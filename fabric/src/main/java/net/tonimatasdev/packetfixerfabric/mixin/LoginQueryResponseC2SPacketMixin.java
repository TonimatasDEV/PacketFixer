package net.tonimatasdev.packetfixerfabric.mixin;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.c2s.login.LoginQueryResponseC2SPacket;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = LoginQueryResponseC2SPacket.class, priority = 999)
public class LoginQueryResponseC2SPacketMixin {

    @SuppressWarnings({"UnusedAssignment", "ParameterCanBeLocal"})
    @Redirect(method = "<init>(Lnet/minecraft/network/PacketByteBuf;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/network/packet/c2s/login/LoginQueryResponseC2SPacket;response:Lnet/minecraft/network/PacketByteBuf;", opcode = Opcodes.PUTFIELD))
    private void newSize(LoginQueryResponseC2SPacket instance, PacketByteBuf data, PacketByteBuf value) {
        data = value.readNullable((p_238039_) -> {
            int i = p_238039_.readableBytes();
            return new PacketByteBuf(p_238039_.readBytes(i));
        });
    }
}
