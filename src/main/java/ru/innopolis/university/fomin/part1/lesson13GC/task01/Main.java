package ru.innopolis.university.fomin.part1.lesson13GC.task01;

import org.apache.log4j.Logger;
import ru.innopolis.university.fomin.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class performs the task conditions lesson13 task
 * Start with VM Options: -Xmx25M -Xloggc:memory_lesson13GC.log
 */
public class Main {
    /**
     * Bound for clean objects
     */
    protected static final int BOUND = 7;

    /**
     * Log4j logger
     */
    protected static final Logger LOGGER = Logger.getLogger(Main.class);

    /**
     * List of objects
     */
    static List<Object> objects = new ArrayList<>();

    /**
     * Switcher in loop
     */
    protected static boolean infinityCreation = true;

    /**
     * Entry point
     * Wait 6 - 7 seconds and see java.lang.OutOfMemoryError
     * Heap size should be 25Mb (-Xmx25M)
     *
     * @param args Input args
     */
    public static void main(String[] args) {
        long i = 0;

        while (infinityCreation) {
            createSomeObject(objects);

            if (i > BOUND && (i % BOUND) == 0) {
                removeSomeObject(objects);
            }
            i++;
        }
    }

    /**
     * Create some object
     * @param objects List of object
     */
    public static void createSomeObject(List<Object> objects) {
        for (int i = 0; i < Utils.getRandomValue(3, 7); i++) {
            objects.add(new Object());
        }
    }

    /**
     * Remove some objects
     * @param objects List of object
     */
    public static void removeSomeObject(List<Object> objects) {
        for (int i = 0; i < Utils.getRandomValue(3, 7); i++) {
            if (objects.size() > 0) {
                objects.remove(0);
            } else {
                break;
            }
        }
    }
}
