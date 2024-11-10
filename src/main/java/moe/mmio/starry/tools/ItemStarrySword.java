package moe.mmio.starry.tools;

import moe.mmio.starry.StarryMod;
import moe.mmio.starry.toolmaterials.ToolMaterialStarry;
import net.minecraft.item.ItemSword;

public class ItemStarrySword extends ItemSword {
    public ItemStarrySword() {
        super(ToolMaterialStarry.STARRY_MATERIAL);
        this.setUnlocalizedName("starry_sword");
        this.setTextureName(StarryMod.MODID + ":starry_sword");
    }
}
