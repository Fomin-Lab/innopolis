package ru.innopolis.university.fomin.examples.gof.behavioral.visitor.example1;

import java.util.List;

public class AtvPartsShippingVisitor implements AtvPartVisitor {
    double shippingAmount = 0;

    @Override
    public void visit(Fender fender) {
        shippingAmount += 3;
        System.out.println("Fender are light and cheap to ship.");
    }

    @Override
    public void visit(Oil oil) {
        shippingAmount += 9;
        System.out.println("Oil is hazardous and has fee to ship.");
    }

    @Override
    public void visit(Wheel wheel) {
        shippingAmount += 15;
        System.out.println("Wheels are bulky and expensive to ship.");
    }

    @Override
    public void visit(PartsOrder partsOrder) {
        System.out.println("If they bought more than 3 things we will give them a discount on shipping.");
        List<AtvPart> parts = partsOrder.getParts();
        if (parts.size() > 3) {
            shippingAmount -= 5;
        }
        System.out.println("Shipping amount is: " + shippingAmount);
    }
}
