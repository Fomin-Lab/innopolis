package ru.innopolis.university.fomin.part1.lesson12;

import ru.innopolis.university.fomin.Utils;
import ru.innopolis.university.fomin.part1.lesson02.task03.algorithms.AlgorithmSort;
import ru.innopolis.university.fomin.part1.lesson02.task03.algorithms.BubbleSort;
import ru.innopolis.university.fomin.part1.lesson02.task03.algorithms.FastSort;
import ru.innopolis.university.fomin.part1.lesson02.task03.models.Person;
import ru.innopolis.university.fomin.part1.lesson02.task03.models.Sex;
import ru.innopolis.university.fomin.part1.lesson12.models.GenderName;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
     * List of names
     */
    protected static List<GenderName> dictionaryNamesWithGender = new ArrayList<>();

    static {
        // Список различных имен
        dictionaryNamesWithGender.add(new GenderName("Андрей", new Sex(MAN)));
        dictionaryNamesWithGender.add(new GenderName("Антон", new Sex(MAN)));
        dictionaryNamesWithGender.add(new GenderName("Аркадий", new Sex(MAN)));
        dictionaryNamesWithGender.add(new GenderName("Денис", new Sex(MAN)));
        dictionaryNamesWithGender.add(new GenderName("Анна", new Sex(WOMAN)));
        dictionaryNamesWithGender.add(new GenderName("Анастасия", new Sex(WOMAN)));
        dictionaryNamesWithGender.add(new GenderName("Татьяна", new Sex(WOMAN)));
        dictionaryNamesWithGender.add(new GenderName("Екатерина", new Sex(WOMAN)));
        dictionaryNamesWithGender.add(new GenderName("Василий", new Sex(MAN)));
        dictionaryNamesWithGender.add(new GenderName("Светлана", new Sex(WOMAN)));
    }

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
        // use stream api
        return Stream.generate(Main::makeRandomPerson).limit(size).collect(Collectors.toList());
    }

    /**
     * Random generate person object
     * @return Random person object
     */
    private static Person makeRandomPerson() {
        // Меняем GenderName на Person и возвращаем случайный объект Person
        // use stream api
        return dictionaryNamesWithGender.stream()
                .map(genderName -> new Person(
                        genderName.getName(),
                        Utils.getRandomValue(18, 45),
                        genderName.getSex()
                ))
                .skip(new Random().nextInt(dictionaryNamesWithGender.size() - 1))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
