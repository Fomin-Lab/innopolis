package ru.innopolis.university.fomin.examples.gof.behavioral.visitor.problem;

public class VisitorProblemDemo {
    public static void main(String[] args) {
        PartsOrder order = new PartsOrder();
        order.addPart(new Wheel());
        order.addPart(new Fender());
        order.addPart(new Oil());

        double shippingCost = order.calculateShipping();
        System.out.println(shippingCost);
    }
}
