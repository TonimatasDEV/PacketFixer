package net.tonimatasdev.potiontimestacker.forge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.tonimatasdev.packetsizedoubler.PacketSizeDoubler;

@Mod(PacketSizeDoubler.MOD_ID)
public class PacketSizeDoublerForge {

    public PacketSizeDoublerForge() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
