package fr.plhume.plhumelib.plugin;

import com.sun.jdi.InternalException;

public final class PLibProvider {

    private static PLib lib = null;

    public static PLib getLib() {
        PLib lib = PLibProvider.lib;
        if (lib == null) {
            throw new InternalException("PLib is not loaded!");
        }

        return lib;
    }

    static void register(PLib lib) {
        PLibProvider.lib = lib;
    }

    static void unregister() {
        PLibProvider.lib = null;
    }

    private PLibProvider() {}
}
