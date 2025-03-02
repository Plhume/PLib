package fr.plhume.plhumelib.configs;

import fr.plhume.plhumelib.configs.modules.DefaultConfigModule;
import fr.plhume.plhumelib.configs.modules.LangConfigModule;
import fr.plhume.plhumelib.utils.FileUtils;

import java.io.File;
import java.io.InputStream;

public class ConfigManager {

    private final File dataFolder;
    private DefaultConfigModule defaultConfig;
    private LangConfigModule langConfig;

    public ConfigManager(File dataFolder) {
        this.dataFolder = dataFolder;
    }

    public void loadDefaultConfig() {
        File configFile = new File(dataFolder, "configuration.yml");
        FileUtils.createFileIfNotExists(configFile);
        defaultConfig = new DefaultConfigModule(configFile);
        InputStream inputStream = FileUtils.getResourceAsStream("configuration.yml");
        defaultConfig.load(inputStream);
        defaultConfig.save();
    }

    public void loadConfig(String name) {
        File configFile = new File(dataFolder, name + ".yml");
        FileUtils.createFileIfNotExists(configFile);
        DefaultConfigModule config = new DefaultConfigModule(configFile);
        InputStream inputStream = FileUtils.getResourceAsStream(name + ".yml");
        config.load(inputStream);
        config.save();
    }

    public DefaultConfigModule getDefaultConfig() {
        return defaultConfig;
    }

    public DefaultConfigModule getConfig(String name) {
        File configFile = new File(dataFolder, name + ".yml");
        return new DefaultConfigModule(configFile);
    }

    public void loadLang(String name) {
        File langFile = new File(dataFolder, "lang/" + name + ".yml");
        FileUtils.createFileIfNotExists(langFile);
        langConfig = new LangConfigModule(langFile);
        InputStream inputStream = FileUtils.getResourceAsStream("lang/" + name + ".yml");
        langConfig.load(inputStream);
        langConfig.save();
    }

    public LangConfigModule getLang(String name) {
        File langFile = new File(dataFolder, "lang/" + name + ".yml");
        return new LangConfigModule(langFile);
    }
}
