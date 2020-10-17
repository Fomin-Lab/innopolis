package ru.innopolis.university.fomin.part1.lesson07.task02;

import ru.innopolis.university.fomin.Utils;
import ru.innopolis.university.fomin.part1.lesson07.task02.generator.Probability;
import ru.innopolis.university.fomin.part1.lesson07.task02.generator.TextGenerator;

/**
 * Class performs the task conditions lesson07.task02
 */
public class Main {
    public static void main(String[] args) {
        TextGenerator generator = new TextGenerator(new Probability());

        // Демонстрация генерации текста (от 2 до 5 абзацев)
        System.out.println(generator.makeText(Utils.getRandomValue(2, 5)));
    }
}
