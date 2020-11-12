package ru.innopolis.university.fomin.examples.gof.structural.bridge.example1;

public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    protected String getFigureName() {
        return "circle";
    }
}
