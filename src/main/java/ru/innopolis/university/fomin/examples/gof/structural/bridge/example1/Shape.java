package ru.innopolis.university.fomin.examples.gof.structural.bridge.example1;

public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    String applyColor() {
        return color.applyColor() + getFigureName();
    }

    protected abstract String getFigureName();
}
