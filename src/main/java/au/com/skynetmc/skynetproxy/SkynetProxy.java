package au.com.skynetmc.skynetproxy;

import net.md_5.bungee.api.plugin.Plugin;

public final class SkynetProxy extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("has enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
