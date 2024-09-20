package dev.tonimatas.packetfixer.mixins;

import dev.tonimatas.packetfixer.util.Config;
import net.minecraft.network.PacketBuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = PacketBuffer.class, priority = 9999)
public class PacketBufferMixin {
    @ModifyConstant(method = "readCompoundTag", constant = @Constant(longValue = 2097152L))
    private long newSize$readCompoundTag(long value) {
        return Config.getNbtMaxSize();
    }
}
