package fr.plhume.plhumelib.utils;

import java.io.File;
import java.io.InputStream;

public class FileUtils {

    public static InputStream getResourceAsStream(String resourcePath) {
        return FileUtils.class.getClassLoader().getResourceAsStream(resourcePath);
    }

    public static void createFileIfNotExists(File file) {
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
