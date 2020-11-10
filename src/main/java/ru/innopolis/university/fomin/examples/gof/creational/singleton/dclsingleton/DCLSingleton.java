package ru.innopolis.university.fomin.examples.gof.creational.singleton.dclsingleton;

class DCLSingleton {
    private static volatile DCLSingleton INSTANCE = null;

    private DCLSingleton() {
    }

    static DCLSingleton getInstance() {
        DCLSingleton localInstance = INSTANCE;
        if (localInstance == null) {
            synchronized (DCLSingleton.class) {
                localInstance = INSTANCE;
                if (localInstance == null) {
                    INSTANCE = localInstance = new DCLSingleton();
                }
            }
        }
        return localInstance;
    }
}