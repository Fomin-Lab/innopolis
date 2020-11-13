package ru.innopolis.university.fomin.examples.gof.behavioral.chainofresponsibility.example1;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EverydayDemo {
    private static final Logger LOGGER = Logger.getLogger(EverydayDemo.class.getName());

    public static void main(String[] args) {
        // level to log at
        LOGGER.setLevel(Level.FINER);

        ConsoleHandler handler = new ConsoleHandler();

        //level to publish at
        handler.setLevel(Level.FINER);
        LOGGER.addHandler(handler);

        LOGGER.finest("Finest level of logging"); // this one won't print
        LOGGER.finer("Finer level, but not as fine as finest");
        LOGGER.fine("Fine, but not as fine as finer or finest");
    }
}
