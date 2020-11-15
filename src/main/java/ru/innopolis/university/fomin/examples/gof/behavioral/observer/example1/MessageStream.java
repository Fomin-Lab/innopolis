package ru.innopolis.university.fomin.examples.gof.behavioral.observer.example1;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageStream extends Subject {
    private Deque<String> messageHistory = new ArrayDeque<>();

    @Override
    void setState(String state) {
        messageHistory.add(state);
        this.notifyObservers();
    }

    @Override
    String getState() {
        return messageHistory.getLast();
    }
}
