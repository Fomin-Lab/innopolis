package ru.innopolis.university.fomin;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Person> persons1 = createPersons();
        List<Person> persons2 = createPersons();

        HumanSort<Person> bubbleHumanSort = new BubbleHumanSort<Person>();
        bubbleHumanSort.doSort(persons1);

        HumanSort<Person> fastHumanSort = new FastHumanSort<Person>();
        fastHumanSort.doSort(persons2);

        printList(persons1);

        System.out.println("Время выполнения (Пузырьком): " + bubbleHumanSort.getTime() + "ms");
        System.out.println("Время выполнения (Быстрая сортировка): " + fastHumanSort.getTime() + "ms");
    }

    private static List<Person> createPersons() {
        List<Person> list = new ArrayList<Person>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Person("Andrey", 12, new Sex(Sex.MAN)));
            list.add(new Person("Vasya", 34, new Sex(Sex.MAN)));
            list.add(new Person("Nastya", 27, new Sex(Sex.WOMAN)));
            list.add(new Person("Sveta", 35, new Sex(Sex.WOMAN)));
            list.add(new Person("Tatyana", 32, new Sex(Sex.WOMAN)));
            list.add(new Person("Maxim", 25, new Sex(Sex.MAN)));
        }
        return list;
    }

    protected static void printList(List<Person> persons) {
        for(Person person : persons) {
            System.out.println(person.toString());
        }
        System.out.println();
    }
}
