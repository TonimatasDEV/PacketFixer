package net.tonimatasdev.packetsizedoubler.mixin;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.login.ServerboundCustomQueryPacket;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(value = ServerboundCustomQueryPacket.class, priority = 999)
public class ServerboundCustomQueryPacketMixin {
    @SuppressWarnings({"UnusedAssignment", "ParameterCanBeLocal"})
    @Redirect(method = "<init>(Lnet/minecraft/network/FriendlyByteBuf;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/network/protocol/login/ServerboundCustomQueryPacket;data:Lnet/minecraft/network/FriendlyByteBuf;", opcode = Opcodes.PUTFIELD))
    private void newSize(ServerboundCustomQueryPacket instance, FriendlyByteBuf data, FriendlyByteBuf value) {
        data = value.readNullable((p_238039_) -> {
            int i = p_238039_.readableBytes();
            return new FriendlyByteBuf(p_238039_.readBytes(i));
        });
    }
}
