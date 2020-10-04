package ru.innopolis.university.fomin;

import ru.innopolis.university.fomin.box.ObjectBox;

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
