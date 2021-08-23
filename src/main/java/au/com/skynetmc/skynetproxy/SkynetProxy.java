package au.com.skynetmc.skynetproxy;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public final class SkynetProxy extends Plugin {

    private static SkynetProxy instance;
    private File file;
    private Configuration configuration;


    @Override
    public void onEnable() {
        // Plugin startup logic
        setInstance(this);
        getProxy().getPluginManager().registerCommand(this, new PingCommand());
        getProxy().getPluginManager().registerListener(this, new PingListener());

        file = new File(ProxyServer.getInstance().getPluginsFolder() + "/printout.yml");


        try {

            if (!file.exists()){
                file.createNewFile();
            }
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            configuration.set("Print_Out.1", "This configuration file works!");

            ConfigurationProvider.getProvider(YamlConfiguration.class).save(configuration, file);

       } catch (IOException e) {
           e.printStackTrace();
       }

        String printout = configuration.getString("Print_Out.1");
        getLogger().info(printout);

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
