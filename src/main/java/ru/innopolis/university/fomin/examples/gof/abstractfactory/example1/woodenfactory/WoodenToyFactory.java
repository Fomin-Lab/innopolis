package ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.woodenfactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.Bear;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.Cat;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.ToyFactory;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.teddyfactory.TeddyCat;

public class WoodenToyFactory implements ToyFactory {
    @Override
    public Bear getBear() {
        return new WoodenBear();
    }

    @Override
    public Cat getCat() {
        return new WoodenCat();
    }
}
