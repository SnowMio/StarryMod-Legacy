package moe.mmio.starry.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;

public class CommandLocateBiome extends CommandBase {

    @Override
    public String getCommandName() {
        return "locatebiome";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return StatCollector.translateToLocal("command.locatebiome.usage");
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length != 1) {
            sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("command.locatebiome.usage")));
            return;
        }

        int biomeID;
        try {
            biomeID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e){
            sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("command.locatebiome.invalid_id")));
            return;
        }

        BiomeGenBase biome = BiomeGenBase.getBiome(biomeID);
        if (biome == null) {
            sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("command.locatebiome.not_found")));
            return;
        }

        EntityPlayer player = (EntityPlayer) sender;
        int searchRadius = 500;
        int closestX = -1, closestZ = -1;
        double closestDistance = Double.MAX_VALUE;

        for (int x = -searchRadius; x <= searchRadius; x += 16) {
            for (int z = -searchRadius; z <= searchRadius; z += 16) {
                BiomeGenBase currentBiome = player.worldObj.getBiomeGenForCoords(player.chunkCoordX + x, player.chunkCoordZ + z);
                if (currentBiome != null && currentBiome.biomeID == biomeID) {
                    double distance = player.getDistance(player.posX + x, player.posY, player.posZ + z);
                    if (distance < closestDistance) {
                        closestDistance = distance;
                        closestX = player.chunkCoordX + x;
                        closestZ = player.chunkCoordZ + z;
                    }
                }
            }
        }

        if (closestX == -1 && closestZ == -1) {
            sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("command.locatebiome.not_found")));
        } else {
            sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocalFormatted("command.locatebiome.found", closestX, closestZ)));
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
