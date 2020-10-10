package ru.innopolis.university.fomin.part1.lesson04.task02;

import ru.innopolis.university.fomin.part1.lesson04.task02.box.ObjectBox;

/**
 * Class performs the task conditions lesson04.task02
 */
public class Main {
    public static void main(String[] args) {
        ObjectBox objectBox = new ObjectBox();
        Object o = new Object();

        /*
            Демонстрация добавления объекта
         */
        objectBox.addObject(o);
        objectBox.addObject(new Object());
        objectBox.dump();

        /*
            Демонстрация удаления объекта
         */
        objectBox.removeObject(o);
        objectBox.dump();
    }
}
