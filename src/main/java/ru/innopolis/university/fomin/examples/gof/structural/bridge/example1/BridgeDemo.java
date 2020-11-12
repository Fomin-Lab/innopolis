package ru.innopolis.university.fomin.examples.gof.structural.bridge.example1;

public class BridgeDemo {
    public static void main(String[] args) {
        Color blue = new Blue();
        Shape blueSquare = new Square(blue);

        Color red = new Red();
        Shape redCircle = new Circle(red);

        System.out.println(blueSquare.applyColor());
        System.out.println(redCircle.applyColor());

        Color green = new Green();
        Shape greenCircle = new Circle(green);
        System.out.println(greenCircle.applyColor());
    }
}
