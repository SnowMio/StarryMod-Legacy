package moe.mmio.starry.config;

import cpw.mods.fml.client.config.GuiConfig;
import moe.mmio.starry.StarryMod;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import static moe.mmio.starry.StarryMod.MODID;

public class ModConfigGui extends GuiConfig {
    public ModConfigGui(GuiScreen parentScreen) {
        super(
                parentScreen,
                new ConfigElement(StarryMod.cfg.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                MODID,
                false,
                false,
                "Starry Mod Configuration"
        );
    }
}
