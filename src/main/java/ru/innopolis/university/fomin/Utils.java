package ru.innopolis.university.fomin;

import java.util.List;
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

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();
    }
}
