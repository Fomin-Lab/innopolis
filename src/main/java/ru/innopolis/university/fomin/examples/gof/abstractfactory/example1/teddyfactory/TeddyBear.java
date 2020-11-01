package ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.teddyfactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.Bear;

public class TeddyBear extends Bear {
    @Override
    protected String getName() {
        return "Teddy Bear";
    }
}
