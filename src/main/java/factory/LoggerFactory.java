package factory;

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
