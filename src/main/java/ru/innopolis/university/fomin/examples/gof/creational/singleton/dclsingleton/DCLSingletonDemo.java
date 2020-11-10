package ru.innopolis.university.fomin.examples.gof.creational.singleton.dclsingleton;

public class DCLSingletonDemo {
    public static void main(String[] args) {

        DCLSingleton
            singleton1 = DCLSingleton.getInstance();
        DCLSingleton
            singleton2 = DCLSingleton.getInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);

    }
}
