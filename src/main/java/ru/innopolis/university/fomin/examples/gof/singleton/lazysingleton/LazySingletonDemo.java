package ru.innopolis.university.fomin.examples.gof.singleton.lazysingleton;

public class LazySingletonDemo {

    public static void main(String[] args) {

        LazySingleton singleton1 = LazySingleton.getInstance();
        LazySingleton singleton2 = LazySingleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);

    }

}
