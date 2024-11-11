package moe.mmio.starry.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.mmio.starry.items.ModItems;
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
    }
}
