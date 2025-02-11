package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.FriendlyByteBuf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(FriendlyByteBuf.class)
public abstract class FriendlyByteBufMixin {
    @ModifyConstant(method = "readNbt()Lnet/minecraft/nbt/CompoundTag;", constant = @Constant(longValue = 2097152L))
    private long newSize(long value) {
        return Config.getNbtMaxSize();
    }

    @ModifyConstant(method = "readVarInt", constant = @Constant(intValue = 5))
    private int readInt$size(int value) {
        return Config.getVarIntSize();
    }

    @ModifyConstant(method = "readVarInt", constant = @Constant(stringValue = "VarInt too big"))
    private String readInt$size(String constant) {
        return "VarInt too big. Packet Fixer configured to " + Config.getVarIntSize() + ". You can modify it in the Packet Fixer config.";
    }

    @ModifyConstant(method = "readVarLong", constant = @Constant(intValue = 10))
    private int readLong$size(int constant) {
        return Config.getVarLong();
    }

    @ModifyConstant(method = "readVarLong", constant = @Constant(stringValue = "VarLong too big"))
    private String readLong$size(String constant) {
        return "VarInt too big. Packet Fixer configured to " + Config.getVarLong() + ". You can modify it in the Packet Fixer config.";
    }
}
