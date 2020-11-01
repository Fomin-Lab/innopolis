package ru.innopolis.university.fomin.examples.gof.singleton.simplesingleton;

public class SimpleSingleton {

    private static SimpleSingleton INSTANCE = new SimpleSingleton();

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        return INSTANCE;
    }
}
