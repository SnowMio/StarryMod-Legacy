package moe.mmio.starry.toolmaterials;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialLegend {
    public static final Item.ToolMaterial LEGEND_MATERIAL = EnumHelper.addToolMaterial(
            "LEGEND_TOOLMATERIAL",
            4,
            230,
            8.0f,
            13.5f - 4,
            10
    );
}
