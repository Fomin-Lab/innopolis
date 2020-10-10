package ru.innopolis.university.fomin;

import ru.innopolis.university.fomin.math.MathBox;
import ru.innopolis.university.fomin.math.Number;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Number[] numbers = createNumbers(12);

        printArray(numbers);

        MathBox mathBox = new MathBox(numbers);
        /*
            Демонстрация работы MathBox.summator()
         */
        int sum = mathBox.summator();
        System.out.println(sum);

        /*
            Демонстрация работы MathBox.splitter()
         */
        mathBox.splitter(2);
    }

    public static Number[] createNumbers(int size) {
        Number[] array = new Number[size];

        for (int i = 0; i < size; i++) {
            array[i] = createNewUniqueNumber(array);
        }

        array[size - 1] = new Number(12);

        return array;
    }

    private static boolean containerNumber(Number[] array, Number number) {
        for (Number n : array) {
            if (n != null && n.equals(number)) {
                return true;
            }
        }
        return false;
    }

    /*
        Создаем новый Number которого нет в массиве
     */
    private static Number createNewUniqueNumber(Number[] array) {
        Number number = new Number(makeValue());
        while (containerNumber(array, number)) {
            number = new Number(makeValue());
        }
        return number;
    }

    private static int makeValue() {
        return getRandomValue(-500, 500);
    }

    private static int getRandomValue(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    public static void printArray(Number[] array) {
        for (Number i : array) {
            System.out.println(i.toString());
        }
        System.out.println();
    }
}
