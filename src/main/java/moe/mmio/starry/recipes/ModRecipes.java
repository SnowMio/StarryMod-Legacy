package moe.mmio.starry.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.mmio.starry.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void recipesRegistry() {
        initializeFurnaceRecipes();
        initializeCraftTableRecipes();
        ModifyedRecipes.modifyVanillaRecipesMain();
    }

    public static void initializeFurnaceRecipes() {
        GameRegistry.addSmelting(ModItems.starry_ore, new ItemStack(ModItems.starry_ingot), 1.4f);
        GameRegistry.addSmelting(ModItems.legend_ore, new ItemStack(ModItems.legend_ingot), 2.0f);
    }

    public static void initializeCraftTableRecipes() {
        GameRegistry.addRecipe(new ItemStack(ModItems.starry_sword),
                " X ",
                " X ",
                " S ",
                'X', ModItems.starry_ingot,
                'S', Items.stick);

        GameRegistry.addRecipe(new ItemStack(ModItems.starry_pickaxe),
                "XXX",
                " S ",
                " S ",
                'X', ModItems.starry_ingot,
                'S', Items.stick);

        GameRegistry.addRecipe(new ItemStack(ModItems.starry_axe),
                "XX ",
                "XS ",
                " S ",
                'X', ModItems.starry_ingot,
                'S', Items.stick);

        GameRegistry.addRecipe(new ItemStack(ModItems.legend_sword),
                " X ",
                " X ",
                " S ",
                'X', ModItems.legend_ingot,
                'S', Items.stick);

        GameRegistry.addRecipe(new ItemStack(ModItems.legend_pickaxe),
                "XXX",
                " S ",
                " S ",
                'X', ModItems.legend_ingot,
                'S', Items.stick);

        GameRegistry.addRecipe(new ItemStack(ModItems.legend_axe),
                "XX ",
                "XS ",
                " S ",
                'X', ModItems.legend_ingot,
                'S', Items.stick);

        GameRegistry.addRecipe(new ItemStack(ModItems.legend_helmet),
                "XEX",
                "X X",
                'X', ModItems.legend_ingot,
                'E', Items.diamond_helmet);

        GameRegistry.addRecipe(new ItemStack(ModItems.legend_chestplate),
                "X X",
                "XEX",
                "XXX",
                'E', Items.diamond_chestplate,
                'X', ModItems.legend_ingot);

        GameRegistry.addRecipe(new ItemStack(ModItems.legend_legging),
                "XEX",
                "X X",
                "X X",
                'X', ModItems.legend_ingot,
                'E', Items.diamond_leggings);

        GameRegistry.addRecipe(new ItemStack(ModItems.legend_boots),
                "X X",
                "X E",
                'X', ModItems.legend_ingot,
                'E', Items.diamond_boots);

        GameRegistry.addRecipe(new ItemStack(ModItems.dragon_resummoner),
                "XEX",
                "EFE",
                "XEX",
                'X', ModItems.legend_ingot,
                'E', Items.diamond,
                'F', Blocks.end_stone);
    }
}
