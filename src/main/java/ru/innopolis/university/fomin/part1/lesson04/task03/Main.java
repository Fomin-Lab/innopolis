package ru.innopolis.university.fomin.part1.lesson04.task03;

import ru.innopolis.university.fomin.part1.lesson04.task03.math.IncompatibleTypesException;
import ru.innopolis.university.fomin.part1.lesson04.task03.math.MathBox;

/**
 * Class performs the task conditions lesson04.task03
 */
public class Main {
    public static void main(String[] args) {
        MathBox mathBox = new MathBox(new Number[] { 2, 4, 3.5f });
        mathBox.dump();

        /*
            Демонстрация работы MathBox.summator()
         */
        System.out.println(mathBox.summator());

        /*
            Демонстрация добавления объекта типа Number в коллекцию
         */
        try {
            mathBox.addObject(3);
        } catch (IncompatibleTypesException e) {
            e.printStackTrace();
        }
        mathBox.dump();

        /*
            Демонстрация добавления объекта типа Object в коллекцию
         */
        try {
            mathBox.addObject(new Object());
        } catch (IncompatibleTypesException e) {
            e.printStackTrace();
        }

        /*
            Демонстрация удаления объекта из коллекции
         */
        mathBox.removeObject(2);
        mathBox.dump();
    }
}