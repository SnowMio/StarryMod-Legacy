package moe.mmio.starry.tools;

import moe.mmio.starry.StarryMod;
import moe.mmio.starry.toolmaterials.ToolMaterialStarry;
import net.minecraft.item.ItemAxe;

public class ItemStarryAxe extends ItemAxe {
    public ItemStarryAxe() {
        super(ToolMaterialStarry.STARRY_MATERIAL);
        this.setUnlocalizedName("starry_axe");
        this.setTextureName(StarryMod.MODID + ":starry_axe");
    }
}
