package ru.innopolis.university.fomin.examples.gof.structural.bridge.example1;

public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    protected String getFigureName() {
        return "square";
    }
}
