package moe.mmio.starry.items;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.mmio.starry.StarryMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModItems {
    public static void mainRegistry() {
        initializeItem();
        registerItems();
    }

    public static Item starry_ingot;

    public static void initializeItem() {
        starry_ingot = new Item().setUnlocalizedName("starry_ingot").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMisc).setTextureName(StarryMod.MODID + "starry_ingot");
    }

    public static void registerItems() {
        GameRegistry.registerItem(starry_ingot, starry_ingot.getUnlocalizedName());
    }
}
