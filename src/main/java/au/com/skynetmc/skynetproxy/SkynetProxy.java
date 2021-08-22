package au.com.skynetmc.skynetproxy;

import net.md_5.bungee.api.plugin.Plugin;

public final class SkynetProxy extends Plugin {

    private static SkynetProxy instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        setInstance(this);
        getProxy().getPluginManager().registerCommand(this, new PingCommand());
        getProxy().getPluginManager().registerListener(this, new PingListener());

        getLogger().info("has enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SkynetProxy getInstance() {
        return instance;
    }

    private static void setInstance(SkynetProxy instance) {
        SkynetProxy.instance = instance;
    }

}
