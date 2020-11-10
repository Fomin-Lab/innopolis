package ru.innopolis.university.fomin.examples.gof.creational.prototype.manualprototype;

public class ShallowPrototypeDemo {

    /**
     * Решение в лоб, самое простое
     * Выполняются те же действия что при клонировании что при создании обхекта
     * @param args Input
     */
    public static void main(String[] args) {
        ComplexObject complexObject = new ComplexObject(123, "John", new Record());
        System.out.println("Complex object: " + complexObject);
        System.out.println("Record: " + complexObject.getRecord());

        ComplexObject clone = new ComplexObject(complexObject);
        System.out.println("Clone: " + clone);
        System.out.println("Record: " + clone.getRecord());
    }
}
