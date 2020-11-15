package ru.innopolis.university.fomin.examples.gof.behavioral.templatemethod.example1;

public abstract class OrderTemplate {
    public boolean isGift;

    public abstract void doCheckout();
    public abstract void doPayment();
    public abstract void doReceipt();
    public abstract void doDelivery();

    public void wrapGift() {
        System.out.println("Gift wrapped.");
    }

    public final void processOrder() {
        doCheckout();
        doPayment();
        if (isGift) {
            wrapGift();
        } else {
            doReceipt();
        }
        doDelivery();
    }
}
