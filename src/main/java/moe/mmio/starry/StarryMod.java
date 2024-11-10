package moe.mmio.starry;

import moe.mmio.starry.items.ModItems;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = StarryMod.MODID, version = StarryMod.VERSION)
public class StarryMod
{
    public static final String MODID = "StarryMod";
    public static final String VERSION = "1.0";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModItems.mainRegistry();
        // some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
