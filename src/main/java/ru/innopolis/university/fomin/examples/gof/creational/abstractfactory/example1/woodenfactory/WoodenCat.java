package ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example1.woodenfactory;

import ru.innopolis.university.fomin.examples.gof.creational.abstractfactory.example1.Cat;

public class WoodenCat extends Cat {
    @Override
    protected String getName() {
        return "Wooden Cat";
    }
}
