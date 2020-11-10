package ru.innopolis.university.fomin.examples.gof.creational.prototype.deepcloneprototype;

@SuppressWarnings("Duplicates")
public class PrototypeDemo {
    public static void main(String[] args) {
        ComplexObject complexObject = new ComplexObject(123, "John", new Record());
        System.out.println("Complex object: " + complexObject);
        System.out.println("Record: " + complexObject.getRecord());

        ComplexObject clone = complexObject.clone();
        System.out.println("Clone: " + clone);
        System.out.println("Record: " + clone.getRecord());
    }
}
