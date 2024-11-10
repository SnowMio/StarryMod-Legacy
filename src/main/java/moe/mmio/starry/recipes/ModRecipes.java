package moe.mmio.starry.recipes;

import cpw.mods.fml.common.registry.GameRegistry;
import moe.mmio.starry.items.ModItems;
import net.minecraft.item.ItemStack;

public class ModRecipes {
    public static void recipesRegistry() {
        GameRegistry.addSmelting(ModItems.starry_ore, new ItemStack(ModItems.starry_ingot), 1.4f);
        GameRegistry.addSmelting(ModItems.legend_ore, new ItemStack(ModItems.legend_ingot), 2.0f);
    }
}
