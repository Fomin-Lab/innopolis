package ru.innopolis.university.fomin.part1.lesson13GC;

import java.util.ArrayList;
import java.util.List;

/**
 * Class performs the task conditions lesson13 task
 */
public class Main {
    static List<Object> objects = new ArrayList();
    /**
     * Entry point
     * @param args Input args
     */
    public static void main(String[] args) {
        while (true) {
            objects.add(new Object());
        }
    }
}
