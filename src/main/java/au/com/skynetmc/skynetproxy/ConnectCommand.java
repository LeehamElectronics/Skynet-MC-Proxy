package au.com.skynetmc.skynetproxy;

import net.md_5.bungee.protocol.packet.PluginMessage;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConnectCommand implements CommandExecutor {

    private PluginMessage pluginMessage = new PluginMessage();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            if (command.getName().equalsIgnoreCase("connect")){
                if (args.length == 1) {
                    // pluginMessage.connect(player, args[0]);
                }
                else {
                    player.sendMessage(ChatColor.RED + "/connect <server>");
                }
            }

        }

        return true;
    }
}
