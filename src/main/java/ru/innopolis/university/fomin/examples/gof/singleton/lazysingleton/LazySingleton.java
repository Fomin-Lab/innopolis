package ru.innopolis.university.fomin.examples.gof.singleton.lazysingleton;

class LazySingleton {

    private static LazySingleton INSTANCE = null;

    private LazySingleton() {
    }

    static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }
}
