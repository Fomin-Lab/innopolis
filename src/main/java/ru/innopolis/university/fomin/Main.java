package ru.innopolis.university.fomin;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = createArray(1000);

        /*
            Для каждого числа k вычислить квадратный корень q.
            Если квадрат целой части q числа равен k, то вывести это число на экран.
         */
        int k = 3;
        for (int i = k; i < array.length; i += k) {
            try {
                int q = (int) squareRoot(array[i]);

                if (q == k) {
                    System.out.println(array[i]);
                }
            } catch (ArithmeticException e) {
                break;
            }
        }
    }

    public static int[] createArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = getRandomValue(-50, 50);
        }

        return array;
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println();
    }

    public static double squareRoot(int value) {
        if (value < 0) throw new ArithmeticException();
        return Math.sqrt(value);
    }

    private static int getRandomValue(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }
}
