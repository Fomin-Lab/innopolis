package ru.innopolis.university.fomin.examples.gof.creational.factorymethod.example1;

public class LoggerProviderFactory {
    public static Logger getLoggingProvider(Class clazz) {
        if (clazz == SLF4JLogger.class) {
            return new SLF4JLogger();
        }
        return new Log4jLogger();
    }
}
