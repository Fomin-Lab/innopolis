package ru.innopolis.university.fomin.examples.gof.behavioral.visitor.example1;

public class Fender implements AtvPart {
    @Override
    public void accept(AtvPartVisitor visitor) {
        visitor.visit(this);
    }
}
