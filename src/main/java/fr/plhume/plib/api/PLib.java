package fr.plhume.plib.api;

import fr.plhume.plib.api.configs.ConfigManager;
import fr.plhume.plib.api.messages.MessagesFormatter;

import java.io.File;

public interface PLib {

    ConfigManager configManager(File dataFolder);

    MessagesFormatter formatter();
}
