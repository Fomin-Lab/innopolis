package ru.innopolis.university.fomin.examples.gof.behavioral.observer.example1;

import java.util.Observable;
import java.util.Observer;

public class ObserverEverydayDemo {
    public static void main(String[] args) {
        TwitterStream messageStream = new TwitterStream();

        Client client1 = new Client("Bryan");
        Client client2 = new Client("Mark");

        messageStream.addObserver(client1);
        messageStream.addObserver(client2);

        messageStream.someoneTweeted();
    }
}

class TwitterStream extends Observable {
    public void someoneTweeted() {
        setChanged();
        notifyObservers();
    }
}

class Client implements Observer {
    private String name;

    Client(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update " + name + "'s stream, someone tweeted something.");
    }
}