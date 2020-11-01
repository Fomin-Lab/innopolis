package ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.woodenfactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.Bear;

public class WoodenBear extends Bear {
    @Override
    protected String getName() {
        return "Wooden Bear";
    }
}
