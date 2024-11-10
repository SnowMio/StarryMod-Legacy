package moe.mmio.starry.creativetabs;

import moe.mmio.starry.items.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ModCreativeTabs extends CreativeTabs {
    public ModCreativeTabs(int index, String label) {
        super(index, label);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ModItems.starry_ore);
    }
}
