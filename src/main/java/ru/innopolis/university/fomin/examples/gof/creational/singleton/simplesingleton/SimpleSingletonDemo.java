package ru.innopolis.university.fomin.examples.gof.creational.singleton.simplesingleton;

public class SimpleSingletonDemo {

    public static void main(String[] args) {

        SimpleSingleton singleton1 = SimpleSingleton.getInstance();
        SimpleSingleton singleton2 = SimpleSingleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);

    }

}
