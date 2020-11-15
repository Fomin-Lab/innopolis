package ru.innopolis.university.fomin.examples.gof.behavioral.observer.example1;

public abstract class Observer {
    protected Subject subject;

    abstract void update();
}
