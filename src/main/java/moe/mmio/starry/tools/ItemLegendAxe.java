package moe.mmio.starry.tools;

import moe.mmio.starry.StarryMod;
import moe.mmio.starry.toolmaterials.ToolMaterialLegend;
import net.minecraft.item.ItemAxe;

public class ItemLegendAxe extends ItemAxe {
    public ItemLegendAxe() {
        super(ToolMaterialLegend.LEGEND_MATERIAL);
        this.setUnlocalizedName("legend_axe");
        this.setTextureName(StarryMod.MODID + ":legend_axe");
    }
}
