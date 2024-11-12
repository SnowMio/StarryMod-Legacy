package moe.mmio.starry.effects;

public class ModEffects {
    public static EffectLegendResurrection legendResurrection;
    public static void initEffects() {
        legendResurrection = new EffectLegendResurrection(31, false, 0xFFFFFF);
    }
}
