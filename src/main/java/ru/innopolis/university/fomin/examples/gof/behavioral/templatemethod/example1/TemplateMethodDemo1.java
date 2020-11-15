package ru.innopolis.university.fomin.examples.gof.behavioral.templatemethod.example1;

public class TemplateMethodDemo1 {
    public static void main(String[] args) {
        System.out.println("Web Order: ");
        OrderTemplate webOrder = new WebOrder();
        webOrder.processOrder();
        System.out.println("===========================");
        System.out.println("Store Order: ");
        OrderTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder();
        System.out.println("===========================");
        System.out.println("Web Order: ");
        OrderTemplate webOrderGift = new WebOrder();
        webOrderGift.isGift = true;
        webOrderGift.processOrder();
    }
}
