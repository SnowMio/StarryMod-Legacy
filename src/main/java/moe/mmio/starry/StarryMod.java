package moe.mmio.starry;

import moe.mmio.starry.items.ModItems;
import moe.mmio.starry.recipes.ModRecipes;
import moe.mmio.starry.worldgen.ModGeneratorRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = StarryMod.MODID, version = StarryMod.VERSION,name = StarryMod.MODNAME)
public class StarryMod
{
    public static final String MODID = "starry";
    public static final String VERSION = "1.0";
    public static final String MODNAME = "Starry";

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModItems.mainRegistry();
        ModGeneratorRegistry.initializeGenerators();
        ModRecipes.recipesRegistry();
    }
}
