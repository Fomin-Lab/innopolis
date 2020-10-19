package ru.innopolis.university.fomin.part1.lesson07.task01;

import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class performs the task conditions lesson07.task01
 */
public class Main {
    public static void main(String[] args) {
        Set<String> words = getSortedWordsInFile("lesson07-task01-input.txt");
        writeSetToFile(words, "lesson07-task01-output.txt");
    }

    /**
     * Search words in file and write to sorted set
     *
     * @param filename File name for read
     * @return set of sorted found words
     */
    public static Set<String> getSortedWordsInFile(String filename) {
        Set<String> words = new TreeSet<>();

        try (FileInputStream fis = new FileInputStream(filename)) {
            Scanner scanner = new Scanner(fis);

            Pattern pattern = Pattern.compile("[А-яA-z]+");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String s = matcher.group();
                    words.add(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    /**
     * Write set of words to file
     *
     * @param words Set of words
     * @param filename Output filename
     */
    public static void writeSetToFile(Set<String> words, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            for (String word : words) {
                fos.write(word.getBytes());
                fos.write('\n');
            }
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
