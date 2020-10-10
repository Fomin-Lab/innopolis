package ru.innopolis.university.fomin.part1.lesson02.task02;

import ru.innopolis.university.fomin.Utils;

/**
 * Class performs the task conditions lesson02.task02
 */
public class Main {
    public static void main(String[] args) {
        int[] array = createArray(1000);

        /*
            Для каждого числа k вычислить квадратный корень q.
            Если квадрат целой части q числа равен k, то вывести это число на экран.
         */
        int k = 3;
        for (int i = k; i < array.length; i += k) {
            int q = (int) squareRoot(array[i]);

            if (q == k) {
                System.out.println(array[i]);
            }
        }
    }

    /**
     * @param size Size of array
     * @return created array with random values
     */
    public static int[] createArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = Utils.getRandomValue(-50, 50);
        }

        return array;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();
    }

    /**
     * @param value The number for which you want to calculate the square root
     * @return Square root of the number passed
     */
    public static double squareRoot(int value) {
        if (value < 0) throw new ArithmeticException();
        return Math.sqrt(value);
    }
}
