package moe.mmio.starry.tools;

import moe.mmio.starry.StarryMod;
import moe.mmio.starry.toolmaterials.ToolMaterialLegend;
import net.minecraft.item.ItemSword;

public class ItemLegendSword extends ItemSword {
    public ItemLegendSword() {
        super(ToolMaterialLegend.LEGEND_MATERIAL);
        this.setUnlocalizedName("legend_sword");
        this.setTextureName(StarryMod.MODID + ":legend_sword");
    }
}
