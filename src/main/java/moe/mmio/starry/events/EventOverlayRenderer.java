package moe.mmio.starry.events;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import moe.mmio.starry.StarryMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class EventOverlayRenderer {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRenderOverlay(RenderGameOverlayEvent.Text event) {
        Minecraft mc = Minecraft.getMinecraft();

        if (mc.theWorld == null || mc.thePlayer == null) {
            return;
        }

        ScaledResolution scaledResolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);

        int day = (int)(mc.theWorld.getWorldTime() / 24000L);

        int x = 5;
        int y = 5;
        mc.fontRenderer.drawString("Starry Mod v" + StarryMod.VERSION, x, y, 0xFFFFFF);
        mc.fontRenderer.drawString("Day " + day, x, y + 10, 0xFFFFFF);
    }
}
