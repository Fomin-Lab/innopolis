package ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.teddyfactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.Cat;

public class TeddyCat extends Cat {
    @Override
    protected String getName() {
        return "Teddy Cat";
    }
}
