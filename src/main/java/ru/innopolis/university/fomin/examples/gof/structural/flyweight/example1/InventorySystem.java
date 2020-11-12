package ru.innopolis.university.fomin.examples.gof.structural.flyweight.example1;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class InventorySystem {
    private final Catalog catalog = new Catalog();
    private final List<Order> orders = new CopyOnWriteArrayList<>();

    void takeOrder(String itemName, int orderNumber) {
        Item item = catalog.lookup(itemName);
        Order order = new Order(orderNumber, item);
        orders.add(order);
    }

    void process() {
        for (Order order : orders) {
            order.processOrder();
            orders.remove(order);
        }
    }

    String report() {
        return "\nTotal Item objects made: " + catalog.totalItemsMade();
    }
}
