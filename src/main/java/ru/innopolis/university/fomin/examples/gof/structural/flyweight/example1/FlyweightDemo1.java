package ru.innopolis.university.fomin.examples.gof.structural.flyweight.example1;

public class FlyweightDemo1 {
    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();

        is.takeOrder("Roomba", 221);
        is.takeOrder("Bose Headphones", 361);
        is.takeOrder("Samsung TV", 432);
        is.takeOrder("Samsung TV", 323);
        is.takeOrder("Roomba", 536);
        is.takeOrder("Bose Headphones", 321);
        is.takeOrder("Samsung TV", 54);
        is.takeOrder("Roomba", 34);
        is.takeOrder("Bose Headphones", 365);
        is.takeOrder("Samsung TV", 332);
        is.takeOrder("Roomba", 456);

        is.process();
        System.out.println(is.report());
    }
}
