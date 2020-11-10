package ru.innopolis.university.fomin.examples.gof.creational.prototype.deepcloneprototype;

public class Record implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
