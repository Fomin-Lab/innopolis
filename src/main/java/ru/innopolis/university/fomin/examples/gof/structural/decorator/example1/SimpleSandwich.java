package ru.innopolis.university.fomin.examples.gof.structural.decorator.example1;

public class SimpleSandwich implements Sandwich {
    @Override
    public String make() {
        return "Bread";
    }
}
