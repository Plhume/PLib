package fr.plhume.plib;

import fr.plhume.plib.api.PLibImpl;
import fr.plhume.plib.api.PLibProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class PLibPlugin extends JavaPlugin {

    private final Logger logger = Logger.getLogger("Minecraft");
    private final String version = getServer().getVersion();

    @Override
    public void onEnable() {
        logger.info("");
        logger.info("██████╗ ██╗     ██╗██████╗ ");
        logger.info("██╔══██╗██║     ██║██╔══██╗ ");
        logger.info("███████╗██║     ██║██████╔╝ ");
        logger.info("██╔═══╝ ██║     ██║██╔══██╗ ");
        logger.info("██║     ███████╗██║██████╔╝ ");
        logger.info("╚═╝     ╚══════╝╚═╝╚═════╝ ");
        logger.info("");

        PLibProvider.register(new PLibImpl());

        logger.info("* Plugin by Plhume");
        logger.info("* Launched on: " + version);
        logger.info("* PLib is now ready!");
    }

    @Override
    public void onDisable() {
        PLibProvider.unregister();

        logger.info("PLib is now disabled!");
    }
}
