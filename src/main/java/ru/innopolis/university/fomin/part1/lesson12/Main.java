package ru.innopolis.university.fomin.part1.lesson12;

import ru.innopolis.university.fomin.Utils;
import ru.innopolis.university.fomin.part1.lesson02.task03.algorithms.AlgorithmSort;
import ru.innopolis.university.fomin.part1.lesson02.task03.algorithms.BubbleSort;
import ru.innopolis.university.fomin.part1.lesson02.task03.algorithms.FastSort;
import ru.innopolis.university.fomin.part1.lesson02.task03.models.Person;
import ru.innopolis.university.fomin.part1.lesson02.task03.models.Sex;
import ru.innopolis.university.fomin.part1.lesson12.models.PersonName;

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
    protected static List<PersonName> dictionaryNames = new ArrayList<>();

    static {
        // Список различных имен
        dictionaryNames.add(new PersonName("Андрей", new Sex(MAN)));
        dictionaryNames.add(new PersonName("Антон", new Sex(MAN)));
        dictionaryNames.add(new PersonName("Аркадий", new Sex(MAN)));
        dictionaryNames.add(new PersonName("Денис", new Sex(MAN)));
        dictionaryNames.add(new PersonName("Анна", new Sex(WOMAN)));
        dictionaryNames.add(new PersonName("Анастасия", new Sex(WOMAN)));
        dictionaryNames.add(new PersonName("Татьяна", new Sex(WOMAN)));
        dictionaryNames.add(new PersonName("Екатерина", new Sex(WOMAN)));
        dictionaryNames.add(new PersonName("Василий", new Sex(MAN)));
        dictionaryNames.add(new PersonName("Светлана", new Sex(WOMAN)));
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
        // Меняем PersonName на Person и возвращаем случайный объект Person
        // use stream api
        return dictionaryNames.stream()
                .map(personName -> new Person(
                        personName.getName(),
                        Utils.getRandomValue(18, 45),
                        personName.getSex())
                )
                .skip(new Random().nextInt(dictionaryNames.size() - 1))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}
