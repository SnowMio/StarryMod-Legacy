package moe.mmio.starry.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.mmio.starry.items.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.Iterator;

// 此类是用于修改原版合成配方的
public class ModifyedRecipes {
    private static void removeRecipe(ItemStack resultItem) {
        Iterator<IRecipe> iterator = CraftingManager.getInstance().getRecipeList().iterator();

        while (iterator.hasNext()) {
            IRecipe recipe = iterator.next();
            if (recipe != null && recipe.getRecipeOutput() != null && recipe.getRecipeOutput().isItemEqual(resultItem)) {
                iterator.remove();
            }
        }
    }

    private static void removeRecipes() {
        removeRecipe(new ItemStack(Items.diamond_helmet));
        removeRecipe(new ItemStack(Items.diamond_chestplate));
        removeRecipe(new ItemStack(Items.diamond_leggings));
        removeRecipe(new ItemStack(Items.diamond_boots));
    }

    private static void reRegisterRecipes() {
        GameRegistry.addRecipe(new ItemStack(Items.diamond_helmet),
                "XAX",
                "X X",
                'X', Items.diamond,
                'A', ModItems.starry_ingot);

        GameRegistry.addRecipe(new ItemStack(Items.diamond_chestplate),
                "X X",
                "XAX",
                "XXX",
                'X', Items.diamond,
                'A', ModItems.starry_ingot);

        GameRegistry.addRecipe(new ItemStack(Items.diamond_leggings),
                "XAX",
                "X X",
                "X X",
                'X', Items.diamond,
                'A', ModItems.starry_ingot);

        GameRegistry.addRecipe(new ItemStack(Items.diamond_boots),
                "X X",
                "X A",
                'X', Items.diamond,
                'A', ModItems.starry_ingot);
    }

    public static void modifyVanillaRecipesMain() {
        removeRecipes();
        reRegisterRecipes();
    }
}
