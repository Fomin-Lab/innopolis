package ru.innopolis.university.fomin;

import ru.innopolis.university.fomin.math.IncompatibleTypesException;
import ru.innopolis.university.fomin.math.MathBox;
import ru.innopolis.university.fomin.math.Number;

public class Main {
    public static void main(String[] args) {
        MathBox mathBox = new MathBox(new Number[] { new Number(2), new Number(4) });
        mathBox.dump();

        /*
            Демонстрация работы MathBox.summator()
         */
        System.out.println(mathBox.summator());

        /*
            Демонстрация добавления объекта типа Number в коллекцию
         */
        try {
            mathBox.addObject(new Number(3));
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
    }
}
