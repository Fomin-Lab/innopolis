package ru.innopolis.university.fomin.examples.gof.factorymethod.example2;

class ShapeFactory {

    static Shape getShape(String shapeType) {

        switch (shapeType) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }

}