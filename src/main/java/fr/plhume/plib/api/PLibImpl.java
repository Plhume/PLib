package fr.plhume.plib.api;

import fr.plhume.plib.api.configs.ConfigManager;
import fr.plhume.plib.api.messages.MessagesFormatter;

import java.io.File;

public class PLibImpl implements PLib {

    @Override
    public ConfigManager configManager(File dataFolder) {
        return new ConfigManager(dataFolder);
    }

    @Override
    public MessagesFormatter formatter() {
        return new MessagesFormatter();
    }
}
