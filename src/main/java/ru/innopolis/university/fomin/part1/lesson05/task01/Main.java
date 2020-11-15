package ru.innopolis.university.fomin.part1.lesson05.task01;

import ru.innopolis.university.fomin.part1.lesson05.task01.models.Animal;
import ru.innopolis.university.fomin.part1.lesson05.task01.models.Person;
import ru.innopolis.university.fomin.part1.lesson05.task01.models.Sex;

/**
 * Class performs the task conditions lesson05.task01
 */
public class Main {
    public static void main(String[] args) throws AnimalExistsException {
        CardFiles cardFiles = new CardFiles();

        // Хозяева животных
        Person ownerKatya = new Person("Катя", 19, Sex.WOMAN);
        Person ownerDenis = new Person("Денис", 21, Sex.MAN);
        Person ownerAnton = new Person("Антон", 22, Sex.MAN);

        // Животные
        // Кот пушок
        Animal animalPushok = new Animal(CardFiles.getIdentifier(), "Пушок", ownerKatya, 5);
        // Черепаха Супчик
        Animal animalSupchick = new Animal(CardFiles.getIdentifier(), "Супчик", ownerDenis, 0.4f);
        // Енот Бандит
        Animal animalBandit = new Animal(CardFiles.getIdentifier(), "Бандит", ownerDenis, 3);
        // Папугай Шкода
        Animal animalSkoda = new Animal(CardFiles.getIdentifier(), "Шкода", ownerKatya, 0.05f);
        // Пиранья Тайсон
        Animal animalTaison = new Animal(CardFiles.getIdentifier(), "Тайсон", ownerAnton, 0.1f);
        // Пиранья Пират
        Animal animalPirat = new Animal(CardFiles.getIdentifier(), "Пират", ownerAnton, 0.1f);

        // Демонстрация добавления животного в картотеку
        cardFiles.addAnimal(animalPushok);
        cardFiles.addAnimal(animalSupchick);
        cardFiles.addAnimal(animalBandit);
        cardFiles.addAnimal(animalSkoda);
        cardFiles.addAnimal(animalTaison);
        cardFiles.addAnimal(animalPirat);

        /*
            Вывод на консоль всех животных, отсортированных по полям - хозяин, кличка животного, вес
         */
        System.out.println(cardFiles.toString());

        // Демонстрация поиска животного по кличке
        System.out.println("Found: " + cardFiles.findAnimalByNickname("Пушок"));
    }
}
