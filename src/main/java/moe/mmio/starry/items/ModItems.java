package moe.mmio.starry.items;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.mmio.starry.StarryMod;
import moe.mmio.starry.blocks.BlockLegendOre;
import moe.mmio.starry.blocks.BlockStarryOre;
import moe.mmio.starry.creativetabs.ModCreativeTabs;
import moe.mmio.starry.tools.ItemStarrySword;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItems {
    public static void mainRegistry() {
        initializeItem();
        registerItems();
    }

    public static final CreativeTabs StarryModCreativeTab = new ModCreativeTabs(CreativeTabs.getNextID(), "starrymod_tab");

    public static Item starry_ingot;
    public static Item legend_ingot;

    public static Item starry_sword;

    public static Block starry_ore;
    public static Block legend_ore;

    public static void initializeItem() {
        starry_ingot = new Item().setUnlocalizedName("starry_ingot").setMaxStackSize(64).setCreativeTab(StarryModCreativeTab).setTextureName(StarryMod.MODID + ":starry_ingot");
        legend_ingot = new Item().setUnlocalizedName("legend_ingot").setMaxStackSize(64).setCreativeTab(StarryModCreativeTab).setTextureName(StarryMod.MODID + ":legend_ingot");

        starry_sword = new ItemStarrySword().setCreativeTab(StarryModCreativeTab);

        starry_ore = new BlockStarryOre(Material.iron).setCreativeTab(StarryModCreativeTab);
        legend_ore = new BlockLegendOre(Material.rock).setCreativeTab(StarryModCreativeTab);
    }

    public static void registerItems() {
        GameRegistry.registerItem(starry_ingot, starry_ingot.getUnlocalizedName());
        GameRegistry.registerItem(legend_ingot, legend_ingot.getUnlocalizedName());

        GameRegistry.registerItem(starry_sword, starry_sword.getUnlocalizedName());

        GameRegistry.registerBlock(starry_ore, starry_ore.getUnlocalizedName());
        GameRegistry.registerBlock(legend_ore, legend_ore.getUnlocalizedName());
    }
}
