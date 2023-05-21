package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerFactory {

    private static LoggerFactory loggerFactory;

    private LoggerFactory() {

    }
    public LoggerFactory getLogger() {
        if (loggerFactory == null){
            loggerFactory = new LoggerFactory();
        }
        return loggerFactory;
    }
}
