package ru.innopolis.university.fomin;

import ru.innopolis.university.fomin.algorithms.AlgorithmSort;
import ru.innopolis.university.fomin.algorithms.BubbleSort;
import ru.innopolis.university.fomin.algorithms.FastSort;

import java.util.*;

import static ru.innopolis.university.fomin.Sex.WOMAN;
import static ru.innopolis.university.fomin.Sex.MAN;

public class Main {

    public static void main(String[] args) {
        List<Person> persons1 = createPersons();
        List<Person> persons2 = new ArrayList<>(persons1);

        AlgorithmSort<Person> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(persons1);

        AlgorithmSort<Person> fastSort = new FastSort<>();
        fastSort.sort(persons2);

        printList(persons1);

        System.out.println("Время выполнения (Пузырьком): " + bubbleSort.getTime() + "ms");
        System.out.println("Время выполнения (Быстрая сортировка): " + fastSort.getTime() + "ms");
    }

    private static List<Person> createPersons() {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(makeRandomPerson());
        }
        return list;
    }

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

        // Случайные возраст
        int age = getRandomValue(18, 45);

        assert entry != null;
        return new Person(entry.getKey(), age, entry.getValue());
    }

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

    private static int getRandomValue(int min, int max) {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    protected static void printList(List<Person> persons) {
        for(Person person : persons) {
            System.out.println(person.toString());
        }
        System.out.println();
    }
}
