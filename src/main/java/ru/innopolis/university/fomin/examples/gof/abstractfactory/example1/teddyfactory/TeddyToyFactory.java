package ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.teddyfactory;

import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.Bear;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.Cat;
import ru.innopolis.university.fomin.examples.gof.abstractfactory.example1.ToyFactory;

public class TeddyToyFactory implements ToyFactory {
    @Override
    public Bear getBear() {
        return new TeddyBear();
    }

    @Override
    public Cat getCat() {
        return new TeddyCat();
    }
}
