package ru.innopolis.university.fomin.part1.lesson04.task01;

import ru.innopolis.university.fomin.Utils;
import ru.innopolis.university.fomin.part1.lesson04.task01.math.MathBox;

/**
 * Class performs the task conditions lesson04.task01
 */
public class Main {
    public static void main(String[] args) {
        Number[] numbers = createNumbers(12);

        System.out.println("Массив чисел: ");
        Utils.printArray(numbers);

        MathBox mathBox = new MathBox(numbers);
        /*
            Демонстрация работы MathBox.summator()
         */
        Number sum = mathBox.summator();
        System.out.println("summator result: " + sum);

        /*
            Демонстрация работы MathBox.splitter()
         */
        System.out.println("\nAfter execute splitter():");
        Utils.printArray(mathBox.splitter(2));
    }

    /**
     * Generate only unique numbers
     * @param size Size of numbers
     * @return Array of numbers
     */
    public static Number[] createNumbers(int size) {
        Number[] array = new Number[size];

        for (int i = 0; i < size; i++) {
            array[i] = createNewUniqueNumber(array);
        }

        return array;
    }

    /**
     * @param array arrays of number
     * @param number value for check
     * @return true or false if number contains in array
     */
    private static boolean containerNumber(Number[] array, Number number) {
        for (Number n : array) {
            if (n != null && n.equals(number)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array Source array
     * @return created unique value
     */
    private static Number createNewUniqueNumber(Number[] array) {
        Number number = makeValue();
        while (containerNumber(array, number)) {
            number = makeValue();
        }
        return number;
    }

    /**
     * @return Random value
     */
    private static int makeValue() {
        return Utils.getRandomValue(-500, 500);
    }
}
