package ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example1;

import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example1.teddyfactory.TeddyToyFactory;

public class Demo1 {
    public static void main(String[] args) {
        ToyFactory toyFactory = new TeddyToyFactory();
        //ToyFactory toyFactory = new WoodenToyFactory();

        Bear bear = toyFactory.getBear();
        Cat cat = toyFactory.getCat();

        System.out.println("I've got " + bear.getName() + " and " + cat.getName());
    }
}
