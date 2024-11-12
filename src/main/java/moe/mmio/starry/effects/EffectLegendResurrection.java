package moe.mmio.starry.effects;

import net.minecraft.potion.Potion;

public class EffectLegendResurrection extends Potion {
    public EffectLegendResurrection(int id, boolean isBadEffect, int color) {
        super(id, isBadEffect, color);
        this.setPotionName("potion.legend_resurrection");
    }
}
