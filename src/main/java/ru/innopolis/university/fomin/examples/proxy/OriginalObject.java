package ru.innopolis.university.fomin.examples.proxy;

public class OriginalObject implements Buyable, Printable {
    public void print() {
        System.out.println("Был вызван метод print()");
    }
    public void buy() {
        System.out.println("Был вызван метод buy()");
    }
}
