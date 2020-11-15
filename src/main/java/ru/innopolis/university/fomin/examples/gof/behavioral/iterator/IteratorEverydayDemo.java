package ru.innopolis.university.fomin.examples.gof.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorEverydayDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("John");
        names.add("Max");

        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
            iterator.remove();
        }

        System.out.println("Names size: " + names.size());
    }
}
