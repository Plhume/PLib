package fr.plhume.plhumelib.plugin;

import fr.plhume.plhumelib.configs.ConfigManager;
import fr.plhume.plhumelib.messages.MessagesFormatter;

public interface PLib {

    MessagesFormatter getFormatter();

    ConfigManager getConfigManager();
}
