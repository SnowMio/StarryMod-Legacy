package moe.mmio.starry.tools;

import moe.mmio.starry.StarryMod;
import moe.mmio.starry.toolmaterials.ToolMaterialStarry;
import net.minecraft.item.ItemPickaxe;

public class ItemStarryPickaxe extends ItemPickaxe {
    public ItemStarryPickaxe() {
        super(ToolMaterialStarry.STARRY_MATERIAL);
        this.setUnlocalizedName("starry_pickaxe");
        this.setTextureName(StarryMod.MODID + ":starry_pickaxe");
    }
}
