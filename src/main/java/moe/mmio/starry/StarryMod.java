package moe.mmio.starry;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import moe.mmio.starry.biomes.BiomeStarry;
import moe.mmio.starry.biomes.ModBiomes;
import moe.mmio.starry.commands.CommandLocateBiome;
import moe.mmio.starry.commands.CommandQueryBiomeID;
import moe.mmio.starry.effects.ModEffects;
import moe.mmio.starry.events.EventLegendArmor;
import moe.mmio.starry.events.EventNoCreeperGriefingBlocks;
import moe.mmio.starry.events.EventOverlayRenderer;
import moe.mmio.starry.items.ModItems;
import moe.mmio.starry.recipes.ModRecipes;
import moe.mmio.starry.worldgen.ModGeneratorRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = StarryMod.MODID, version = StarryMod.VERSION,name = StarryMod.MODNAME)
public class StarryMod
{
    public static final String MODID = "starry";
    public static final String VERSION = "1.0";
    public static final String MODNAME = "Starry";
    public static final boolean IS_DEV_BUILD = true;
    /*
     * Welcome to Here!
     */

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModItems.mainRegistry();
        ModEffects.initEffects();
        ModGeneratorRegistry.initializeGenerators();
        ModRecipes.recipesRegistry();
        ModBiomes.initModBiomes();

        // 事件注册
        MinecraftForge.EVENT_BUS.register(new EventNoCreeperGriefingBlocks());
        MinecraftForge.EVENT_BUS.register(new BiomeStarry(215));
        MinecraftForge.EVENT_BUS.register(new EventLegendArmor());
        MinecraftForge.EVENT_BUS.register(new EventOverlayRenderer());
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandLocateBiome());
        event.registerServerCommand(new CommandQueryBiomeID());
    }
}
