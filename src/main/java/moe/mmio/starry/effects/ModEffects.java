package moe.mmio.starry.effects;

public class ModEffects {
    public static EffectLegendResurrection legendResurrection;
    public static void initEffects() {
        // 在1.7.10中，药水id的分配最高上限是31超过这个值会导致崩溃
        // 你她喵的还不支持动态分配
        legendResurrection = new EffectLegendResurrection(31, false, 0xFFFFFF);
    }
}
