package ru.innopolis.university.fomin.part1.lesson12;

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
 * Class performs the task conditions lesson12 task
 * Для использования stream api было выбрано решение задачи 3 из лекции 2
 * Оригинал находится в пакете: ru.innopolis.university.fomin.part1.lesson02.task03
 * Переделанные участки кода помечены комментарием // use stream api
 */
public class Main {
    /**
     * Number of persons for creation
     */
    protected static int countPersons = 25;

    /**
     * Entry point
     * @param args Input args
     */
    public static void main(String[] args) {
        List<Person> persons1 = createPersons(countPersons);
        List<Person> persons2 = new ArrayList<>(persons1);

        AlgorithmSort<Person> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(persons1);

        AlgorithmSort<Person> fastSort = new FastSort<>();
        fastSort.sort(persons2);

        // use stream api
        persons1.forEach(System.out::println);

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
            put("Светлана", new Sex(WOMAN));
        }};

        // Выбор случайного имени
        // use stream api
        Map.Entry<String, Sex> entry = names.entrySet()
                .stream()
                .skip(new Random().nextInt(names.size() - 1))
                .findFirst()
                .orElseThrow(NullPointerException::new);

        // Случайный возраст
        int age = Utils.getRandomValue(18, 45);

        return new Person(entry.getKey(), age, entry.getValue());
    }
}
