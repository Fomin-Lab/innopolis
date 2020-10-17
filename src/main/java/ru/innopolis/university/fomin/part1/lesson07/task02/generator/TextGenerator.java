package ru.innopolis.university.fomin.part1.lesson07.task02.generator;

import ru.innopolis.university.fomin.Utils;
import ru.innopolis.university.fomin.part1.lesson07.task02.dictionaries.Dictionary;

import java.util.*;

/**
 * Text generator
 */
public class TextGenerator {
    protected Probability probability;

    public TextGenerator(Probability probability) {
        this.probability = probability;
    }

    /**
     * @return Probability instance
     */
    public Probability getProbability() {
        return probability;
    }

    /**
     * @param probability Probability instance
     */
    public void setProbability(Probability probability) {
        this.probability = probability;
    }

    /**
     * @param countLetters Number of letters
     * @return Random word
     */
    public String makeWord(int countLetters) {
        char[] chars = new char[countLetters];

        for (int i = 0; i < countLetters; i++) {
            chars[i] = getRandomLatinLetter();
        }

        return String.valueOf(chars);
    }

    /**
     * @param countWords Number of words
     * @return Random sentence
     */
    public String makeSentence(int countWords) {
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < countWords; i++) {
            String word = getRandomWord();

            // Первое слово с заглавной буквы
            if (i == 0) {
                result.append(toUpperCaseFirstLetter(word));
            } else {
                result.append(word);
            }

            // С вероятностью 1% вставляем запятую после слова, кроме последнего
            if (!isLastItem(i, countWords)) {
                if (random.nextInt(100) == 1) {
                    result.append(", ");
                } else {
                    result.append(" ");
                }
            }
        }

        // в конце предложение ставим один из знаков (.|?|!)
        result.append(getRandomPunctuationMark()).append(" ");

        return result.toString();
    }

    /**
     * @param countSentence Number of sentence
     * @return Random paragraph
     */
    public String makeParagraph(int countSentence) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < countSentence; i++) {
            result.append(makeSentence(Utils.getRandomValue(1, 15)));
        }

        // Сохраняем параграф для учета вероятности слов
        if (probability != null) {
            probability.setParagraph(result.toString());
        }

        result.append("\r\n");

        return result.toString();
    }

    /**
     * @param countParagraph Number of paragraph
     * @return Random text
     */
    public String makeText(int countParagraph) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < countParagraph; i++) {
            result.append(makeParagraph(Utils.getRandomValue(1, 20)));
        }

        return result.toString();
    }

    /**
     * @param index Item index
     * @param size Size of array
     * @return true if last item
     */
    private boolean isLastItem(int index, int size) {
        return index + 1 == size;
    }

    /**
     * First word in sentence
     * @param word Word
     * @return First letter upper case
     */
    private String toUpperCaseFirstLetter(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    /**
     * Take into account the probability
     * @return Random word
     */
    private String getRandomWord() {
        if (probability != null && probability.isLoaded()) {
            Map.Entry<String, Integer> probabilityEntry = probability.getQueueWords().poll();
            /*
                Генерируем случайное число в диапазоне от 0 до 100
                Например: слово в предыдущем абзаце имеет вероятность 50% повторится в след. абзаце, то
                если сгенерированное случайное число попадает в интервал от 0 до 50 - то считаем что возникло событие и добавляем
                это слово в предложение, иначе считаем что событие не возникло и генерируем новое слово.
                Все слова могут повторится с вероятностью от 1 до 100%.
             */
            if (probabilityEntry != null && new Random().nextInt(100 + 1) <= probabilityEntry.getValue()) {
                // вызываем toLowerCase т.к. сохраненное слово могло стоять в начале предложения
                return probabilityEntry.getKey().toLowerCase();
            }
        }

        return makeWord(Utils.getRandomValue(1, 15));
        // example with russian words
        //return Dictionary.WORDS.get(new Random().nextInt(Dictionary.WORDS.size())).toLowerCase();
    }

    /**
     * @return Random char
     */
    private char getRandomPunctuationMark() {
        return Dictionary.CHARS_END_SENTENCE[new Random().nextInt(Dictionary.CHARS_END_SENTENCE.length)];
    }

    /**
     * @return Random letter
     */
    private char getRandomLatinLetter() {
        return Dictionary.LATIN_LETTERS[new Random().nextInt(Dictionary.LATIN_LETTERS.length)];
    }
}
