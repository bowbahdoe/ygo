package dev.mccue.ygo.logger;

public final class Log {
    private static final System.Logger LOGGER
            = System.getLogger("dev.mccue.ygo");

    private Log() {}

    public static void info(String message) {
        LOGGER.log(System.Logger.Level.INFO, message);
    }


    public static void warn(String message) {
        LOGGER.log(System.Logger.Level.WARNING, message);
    }

    public static void error(String message) {
        LOGGER.log(System.Logger.Level.ERROR, message);
    }

    public static void error(String message, Throwable t) {
        LOGGER.log(System.Logger.Level.ERROR, message, t);
    }
}
