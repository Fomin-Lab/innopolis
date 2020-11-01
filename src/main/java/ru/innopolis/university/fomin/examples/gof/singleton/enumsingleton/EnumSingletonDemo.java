package ru.innopolis.university.fomin.examples.gof.singleton.enumsingleton;

public class EnumSingletonDemo {

    public static void main(String[] args) {

        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;
        System.out.println(singleton1);
        System.out.println(singleton2);

    }

}
