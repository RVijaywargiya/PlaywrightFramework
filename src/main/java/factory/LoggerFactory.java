package factory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerFactory {

    private static final ThreadLocal<Logger> logger = new ThreadLocal<>();

    public static void setLogger() {
        if(getLogger() == null) {
            logger.set(LogManager.getLogger(LoggerFactory.class));
        }
    }

    public static Logger getLogger() {
        return logger.get();
    }

    public static Logger initLogger() {
        setLogger();
        setLogLevel();
        return getLogger();
    }

    public static void setLogLevel() {
        getLogger().atLevel(Level.DEBUG);
    }
}
