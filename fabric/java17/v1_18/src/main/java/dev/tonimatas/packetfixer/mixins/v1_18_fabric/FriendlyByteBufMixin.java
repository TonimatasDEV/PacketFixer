package dev.tonimatas.packetfixer.mixins.v1_18_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(FriendlyByteBuf.class)
public abstract class FriendlyByteBufMixin {
    @ModifyConstant(method = "readNbt()Lnet/minecraft/nbt/CompoundTag;", constant = @Constant(longValue = 2097152L))
    private long packetfixer$readNbt$newSize(long value) {
        return Config.getNbtMaxSize();
    }

    @ModifyConstant(method = "readVarInt", constant = @Constant(intValue = 5))
    private int packetfixer$readInt$newSize(int value) {
        return Config.getVarIntSize();
    }

    @ModifyConstant(method = "readVarInt", constant = @Constant(stringValue = "VarInt too big"))
    private String packetfixer$readInt$newSize(String constant) {
        return "VarInt too big. Packet Fixer configured to " + Config.getVarIntSize() + ". You can modify it in the Packet Fixer config.";
    }

    @ModifyConstant(method = "readVarLong", constant = @Constant(intValue = 10))
    private int packetfixer$readLong$newSize(int constant) {
        return Config.getVarLong();
    }

    @ModifyConstant(method = "readVarLong", constant = @Constant(stringValue = "VarLong too big"))
    private String packetfixer$readLong$newSize(String constant) {
        return "VarInt too big. Packet Fixer configured to " + Config.getVarLong() + ". You can modify it in the Packet Fixer config.";
    }

    @ModifyConstant(method = "readUtf()Ljava/lang/String;", constant = @Constant(intValue = 32767))
    private int packetfixer$readUtf$newSize(int value) {
        return Config.getStringSize();
    }

    @ModifyConstant(method = "writeUtf(Ljava/lang/String;)Lnet/minecraft/network/FriendlyByteBuf;", constant = @Constant(intValue = 32767))
    private int packetfixer$writeUtf$newSize(int value) {
        return Config.getStringSize();
    }
}
