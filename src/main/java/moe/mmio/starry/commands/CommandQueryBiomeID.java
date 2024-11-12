package moe.mmio.starry.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.StatCollector;
import net.minecraft.world.biome.BiomeGenBase;

public class CommandQueryBiomeID extends CommandBase {
    @Override
    public String getCommandName() {
        return "querybiome";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return StatCollector.translateToLocal("command.querybiome.usage");
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length != 1) {
            sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("command.querybiome.usage")));
            return;
        }

        int biomeID;
        try {
            biomeID = Integer.parseInt(args[0]);
        } catch (NumberFormatException e){
            sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("command.querybiome.invalid_id")));
            return;
        }

        BiomeGenBase biome = BiomeGenBase.getBiome(biomeID);
        if (biome == null) {
            sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("command.querybiome.not_found")));
        } else {
            sender.addChatMessage(new ChatComponentText(StatCollector.translateToLocalFormatted("command.querybiome.name", biome.biomeName)));
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }
}
