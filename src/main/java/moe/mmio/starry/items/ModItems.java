package moe.mmio.starry.items;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.mmio.starry.StarryMod;
import moe.mmio.starry.blocks.BlockStarryOre;
import moe.mmio.starry.creativetabs.ModCreativeTabs;
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

    public static Block starry_ore;

    public static void initializeItem() {
        starry_ingot = new Item().setUnlocalizedName("starry_ingot").setMaxStackSize(64).setCreativeTab(StarryModCreativeTab).setTextureName(StarryMod.MODID + ":starry_ingot");

        starry_ore = new BlockStarryOre(Material.iron).setCreativeTab(StarryModCreativeTab);
    }

    public static void registerItems() {
        GameRegistry.registerItem(starry_ingot, starry_ingot.getUnlocalizedName());

        GameRegistry.registerBlock(starry_ore, starry_ore.getUnlocalizedName());
    }
}
