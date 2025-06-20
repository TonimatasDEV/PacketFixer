package dev.tonimatas.packetfixer.mixins.v1_20_5_fabric;

import dev.tonimatas.packetfixer.common.Config;
import net.minecraft.network.codec.ByteBufCodecs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ByteBufCodecs.class)
public interface ByteBufCodecsMixin {
    @ModifyConstant(method = "*()Lnet/minecraft/nbt/NbtAccounter;", constant = @Constant(longValue = 2097152L))
    private static long newSize(long value) {
        return Config.getNbtMaxSize();
    }
}
