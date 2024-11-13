package moe.mmio.starry.armors;

import moe.mmio.starry.StarryMod;
import moe.mmio.starry.items.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorLegendArmor extends ItemArmor {
    public static final ArmorMaterial LEGEND_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("LEGEND", 2048, new int[]{4, 7, 9, 4}, 10);

    public ArmorLegendArmor(int armorType) {
        super(LEGEND_ARMOR_MATERIAL, 0, armorType);
        this.setMaxStackSize(1);
    }

    public static boolean isWearingFullSet(EntityPlayer player) {
        ItemStack head = player.getEquipmentInSlot(4);
        ItemStack chest = player.getEquipmentInSlot(3);
        ItemStack legs = player.getEquipmentInSlot(2);
        ItemStack boots = player.getEquipmentInSlot(1);
        return head != null && head.getItem() instanceof ArmorLegendArmor &&
                chest != null && chest.getItem() instanceof ArmorLegendArmor &&
                legs != null && legs.getItem() instanceof ArmorLegendArmor &&
                boots != null && boots.getItem() instanceof ArmorLegendArmor;
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return StarryMod.MODID + ":textures/models/armor/legend_layer_" + (armorType == 2 ? "2" : "1") + ".png";
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == ModItems.legend_ingot;
    }
}
