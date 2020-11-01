package ru.innopolis.university.fomin.examples.gof.factorymethod.example1;

public class Demo1 {
    public static void main(String[] args) {
        Logger logger = LoggerProviderFactory.getLoggingProvider(SLF4JLogger.class);
        logger.logMessage("hello");

        logger = LoggerProviderFactory.getLoggingProvider(Log4jLogger.class);
        logger.logMessage("hello");
    }
}
