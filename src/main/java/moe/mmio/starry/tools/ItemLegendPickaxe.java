package moe.mmio.starry.tools;

import moe.mmio.starry.StarryMod;
import moe.mmio.starry.toolmaterials.ToolMaterialLegend;
import net.minecraft.item.ItemPickaxe;

public class ItemLegendPickaxe extends ItemPickaxe {
    public ItemLegendPickaxe() {
        super(ToolMaterialLegend.LEGEND_MATERIAL);
        this.setUnlocalizedName("legend_pickaxe");
        this.setTextureName(StarryMod.MODID + ":legend_pickaxe");
    }
}
