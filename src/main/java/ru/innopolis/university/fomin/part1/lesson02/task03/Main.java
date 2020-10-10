package ru.innopolis.university.fomin.part1.lesson02.task03;

import ru.innopolis.university.fomin.Utils;
import ru.innopolis.university.fomin.part1.lesson02.task03.algorithms.AlgorithmSort;
import ru.innopolis.university.fomin.part1.lesson02.task03.algorithms.BubbleSort;
import ru.innopolis.university.fomin.part1.lesson02.task03.algorithms.FastSort;
import ru.innopolis.university.fomin.part1.lesson02.task03.models.Person;
import ru.innopolis.university.fomin.part1.lesson02.task03.models.Sex;

import java.util.*;

import static ru.innopolis.university.fomin.part1.lesson02.task03.models.Sex.WOMAN;
import static ru.innopolis.university.fomin.part1.lesson02.task03.models.Sex.MAN;

/**
 * Class performs the task conditions lesson02.task03
 */
public class Main {

    public static void main(String[] args) {
        List<Person> persons1 = createPersons(1000);
        List<Person> persons2 = new ArrayList<>(persons1);

        AlgorithmSort<Person> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(persons1);

        AlgorithmSort<Person> fastSort = new FastSort<>();
        fastSort.sort(persons2);

        Utils.printList(persons1);

        System.out.println("Время выполнения (Пузырьком): " + bubbleSort.getTime() + "ms");
        System.out.println("Время выполнения (Быстрая сортировка): " + fastSort.getTime() + "ms");
    }

    /**
     * @return List of random persons
     */
    private static List<Person> createPersons(int size) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(makeRandomPerson());
        }
        return list;
    }

    /**
     * Random generate person object
     * @return Random person object
     */
    private static Person makeRandomPerson() {
        // Таблица различных имен
        Map<String, Sex> names = new HashMap<String, Sex>() {{
            put("Андрей", new Sex(MAN));
            put("Антон", new Sex(MAN));
            put("Аркадий", new Sex(MAN));
            put("Денис", new Sex(MAN));
            put("Анна", new Sex(WOMAN));
            put("Анастасия", new Sex(WOMAN));
            put("Татьяна", new Sex(WOMAN));
            put("Екатерина", new Sex(WOMAN));
            put("Василий", new Sex(MAN));
            put("Светалана", new Sex(WOMAN));
        }};

        // Выбор случайного имени
        Random random = new Random();
        Map.Entry<String, Sex> entry = getEntryByIndex(names, random.nextInt(names.size()) );

        // Случайный возраст
        int age = Utils.getRandomValue(18, 45);

        assert entry != null;
        return new Person(entry.getKey(), age, entry.getValue());
    }

    /**
     * @param names Map of names with sex
     * @param index Needed index of entry
     * @return Entry by index
     */
    private static Map.Entry<String, Sex> getEntryByIndex(Map<String, Sex> names, int index) {
        int i = 0;
        for (Map.Entry<String, Sex> entry : names.entrySet()) {
            if (i == index) {
                return entry;
            }
            i++;
        }
        return null;
    };
}
