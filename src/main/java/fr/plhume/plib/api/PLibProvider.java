package fr.plhume.plib.api;

public final class PLibProvider {

    private static PLib pLib = null;

    public static PLib getLib() {
        PLib pLib = PLibProvider.pLib;

        if (pLib == null) {
            throw new LoadingError();
        }

        return pLib;
    }

    public static void register(PLib pLib) {
        PLibProvider.pLib = pLib;
    }

    public static void unregister() {
        PLibProvider.pLib = null;
    }

    private PLibProvider() {}

    private static final class LoadingError extends IllegalStateException {
        private static final String MESSAGE = "The PLib is not loaded!\n" +
                "  a) The PLib had a loading error\n" +
                "  b) The plugin did not correctly declare the PLib\n";

        LoadingError() {
            super(MESSAGE);
        }
    }
}
