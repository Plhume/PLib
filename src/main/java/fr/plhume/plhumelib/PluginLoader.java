package fr.plhume.plhumelib;

import org.bukkit.plugin.java.JavaPlugin;

public class PluginLoader extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("");
        getLogger().info("██████╗ ██╗     ██╗██████╗ ");
        getLogger().info("██╔══██╗██║     ██║██╔══██╗ ");
        getLogger().info("███████╗██║     ██║██████╔╝ ");
        getLogger().info("██╔═══╝ ██║     ██║██╔══██╗ ");
        getLogger().info("██║     ███████╗██║██████╔╝ ");
        getLogger().info("╚═╝     ╚══════╝╚═╝╚═════╝ ");
        getLogger().info("");
        getLogger().info("* Plugin by Plhume");
        getLogger().info("* Launched on: " + getServer().getVersion());
        getLogger().info("* PlhumeLib is now ready!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlhumeLib is now disabled!");
    }
}
