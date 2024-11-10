package moe.mmio.starry.toolmaterials;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialStarry {
    public static final Item.ToolMaterial STARRY_MATERIAL = EnumHelper.addToolMaterial(
            "STARRY_TOOLMATERIAL",  // 材料名称
            3,                 // 挖掘等级
            230,                  // 耐久度
            8.5f,                // 挖掘效率
            8.5f,                 // 攻击伤害
            10               // Enchant Ability
    );
}
