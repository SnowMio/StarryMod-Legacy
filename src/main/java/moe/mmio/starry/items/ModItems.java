package moe.mmio.starry.items;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.mmio.starry.StarryMod;
import moe.mmio.starry.api.ItemWings;
import moe.mmio.starry.armors.ArmorLegendArmor;
import moe.mmio.starry.blocks.*;
import moe.mmio.starry.creativetabs.ModCreativeTabs;
import moe.mmio.starry.tools.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
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
    public static Item starry_pickaxe;
    public static Item starry_axe;
    public static Item legend_sword;
    public static Item legend_pickaxe;
    public static Item legend_axe;

    public static Item legend_helmet;
    public static Item legend_chestplate;
    public static Item legend_legging;
    public static Item legend_boots;

    public static Item dragon_resummoner;

    public static Block starry_ore;
    public static Block legend_ore;
    public static Block obsidian_ore;
    public static Block starry_stone;

    public static BlockFalling hell_gravel;

    public static void initializeItem() {
        starry_ingot = new Item().setUnlocalizedName("starry_ingot").setMaxStackSize(64).setCreativeTab(StarryModCreativeTab).setTextureName(StarryMod.MODID + ":starry_ingot");
        legend_ingot = new Item().setUnlocalizedName("legend_ingot").setMaxStackSize(64).setCreativeTab(StarryModCreativeTab).setTextureName(StarryMod.MODID + ":legend_ingot");

        starry_sword = new ItemStarrySword().setCreativeTab(StarryModCreativeTab);
        starry_pickaxe = new ItemStarryPickaxe().setCreativeTab(StarryModCreativeTab);
        starry_axe = new ItemStarryAxe().setCreativeTab(StarryModCreativeTab);
        legend_sword = new ItemLegendSword().setCreativeTab(StarryModCreativeTab);
        legend_pickaxe = new ItemLegendPickaxe().setCreativeTab(StarryModCreativeTab);
        legend_axe = new ItemLegendAxe().setCreativeTab(StarryModCreativeTab);

        dragon_resummoner = new ItemDragonResummoner().setCreativeTab(StarryModCreativeTab);

        legend_helmet = new ArmorLegendArmor(0)
                .setUnlocalizedName("legend_helmet")
                .setTextureName(StarryMod.MODID + ":legend_helmet")
                .setCreativeTab(StarryModCreativeTab);
        legend_chestplate = new ArmorLegendArmor(1)
                .setUnlocalizedName("legend_chestplate")
                .setTextureName(StarryMod.MODID + ":legend_chestplate")
                .setCreativeTab(StarryModCreativeTab);
        legend_legging = new ArmorLegendArmor(2)
                .setUnlocalizedName("legend_legging")
                .setTextureName(StarryMod.MODID + ":legend_legging")
                .setCreativeTab(StarryModCreativeTab);
        legend_boots = new ArmorLegendArmor(3)
                .setUnlocalizedName("legend_boots")
                .setTextureName(StarryMod.MODID + ":legend_boots")
                .setCreativeTab(StarryModCreativeTab);

        starry_ore = new BlockStarryOre(Material.iron).setCreativeTab(StarryModCreativeTab);
        legend_ore = new BlockLegendOre(Material.rock).setCreativeTab(StarryModCreativeTab);
        obsidian_ore = new BlockObsidianOre(Material.rock).setCreativeTab(StarryModCreativeTab);
        starry_stone = new BlockStarryStone(Material.rock).setCreativeTab(StarryModCreativeTab);

        hell_gravel = (BlockFalling) new BlockHellGravel(Material.sand).setCreativeTab(StarryModCreativeTab);
    }

    public static void registerItems() {
        GameRegistry.registerItem(starry_ingot, starry_ingot.getUnlocalizedName());
        GameRegistry.registerItem(legend_ingot, legend_ingot.getUnlocalizedName());

        GameRegistry.registerItem(starry_sword, starry_sword.getUnlocalizedName());
        GameRegistry.registerItem(starry_pickaxe, starry_pickaxe.getUnlocalizedName());
        GameRegistry.registerItem(starry_axe, starry_axe.getUnlocalizedName());
        GameRegistry.registerItem(legend_sword, legend_sword.getUnlocalizedName());
        GameRegistry.registerItem(legend_pickaxe, legend_pickaxe.getUnlocalizedName());
        GameRegistry.registerItem(legend_axe, legend_axe.getUnlocalizedName());

        GameRegistry.registerItem(dragon_resummoner, dragon_resummoner.getUnlocalizedName());

        GameRegistry.registerItem(legend_helmet, legend_helmet.getUnlocalizedName());
        GameRegistry.registerItem(legend_chestplate, legend_chestplate.getUnlocalizedName());
        GameRegistry.registerItem(legend_legging, legend_legging.getUnlocalizedName());
        GameRegistry.registerItem(legend_boots, legend_boots.getUnlocalizedName());

        GameRegistry.registerBlock(starry_ore, starry_ore.getUnlocalizedName());
        GameRegistry.registerBlock(legend_ore, legend_ore.getUnlocalizedName());
        GameRegistry.registerBlock(obsidian_ore, obsidian_ore.getUnlocalizedName());
        GameRegistry.registerBlock(starry_stone, starry_stone.getUnlocalizedName());

        GameRegistry.registerBlock(hell_gravel, hell_gravel.getUnlocalizedName());
    }
}
