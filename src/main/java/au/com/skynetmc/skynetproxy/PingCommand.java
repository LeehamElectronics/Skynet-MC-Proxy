package au.com.skynetmc.skynetproxy;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {

    public PingCommand() {
        super("ping");
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            int ping = player.getPing();

            player.sendMessage(new TextComponent(ChatColor.GOLD + "[SkynetMC] " + ChatColor.GRAY + "Your ping is: " + ChatColor.GREEN + ping));
        }
    }
}
