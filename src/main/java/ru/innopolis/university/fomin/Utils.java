package ru.innopolis.university.fomin;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Utils for tasks
 */
public class Utils {
    public static int getRandomValue(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static void printList(List<?> persons) {
        for(Object person : persons) {
            System.out.println(person.toString());
        }
        System.out.println();
    }

    public static void printArray(Object[] array) {
        printList(Arrays.asList(array));
    }

    public static void printMap(Map<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey().toString() + ": " + entry.getValue().toString());
        }
        System.out.println();
    }
}
