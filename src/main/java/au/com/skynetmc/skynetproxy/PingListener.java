package au.com.skynetmc.skynetproxy;

import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.net.InetSocketAddress;

public class PingListener implements Listener {

    private SkynetProxy plugin = SkynetProxy.getInstance();

    @EventHandler
    public void onPlayerJoin(ProxyPingEvent event) {

        InetSocketAddress address = event.getConnection().getVirtualHost();

        plugin.getLogger().info(address.getHostName());
    }

}
