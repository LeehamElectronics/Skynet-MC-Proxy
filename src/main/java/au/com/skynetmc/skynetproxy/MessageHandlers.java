package au.com.skynetmc.skynetproxy;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.event.PluginMessageEvent;

import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;
import net.md_5.bungee.api.plugin.Plugin;


public class MessageHandlers implements PluginMessageListener {

    private SkynetProxy plugin = SkynetProxy.getInstance();

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {

        if(!channel.equalsIgnoreCase("BungeeCord")) {
            return;
        }
        ByteArrayDataInput input = ByteStreams.newDataInput(message);
        String subChannel = input.readUTF();

    }

    public void connect(Player player, String server){
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Connect");
        output.writeUTF(server);

       // player.sendPluginMessage(plugin, "BungeeYo", output.toByteArray());
        player.getServer().sendPluginMessage((org.bukkit.plugin.Plugin) this, "BungeeYo", output.toByteArray());
    }

}
