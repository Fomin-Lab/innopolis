package ru.innopolis.university.fomin.examples.gof.creational.factorymethod.example1;

public class SLF4JLogger implements Logger {
    @Override
    public void logMessage(String message) {
        System.out.println("SLF4J logger: " + message);
    }
}
