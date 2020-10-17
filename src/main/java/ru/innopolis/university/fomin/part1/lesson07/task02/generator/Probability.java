package ru.innopolis.university.fomin.part1.lesson07.task02.generator;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Probability
 */
public class Probability {
    /**
     * Preview paragraph
     */
    protected String paragraph;

    /**
     * Map of words and probability
     */
    protected Map<String, Integer> percentProbabilityAndWords;

    /**
     * Очередь которую будем освобождать при генерации следующего
     * параграфа. Очередь хранит слова из предыдущего абзаца со значениями вероятности.
     */
    protected Queue<Map.Entry<String, Integer>> queueWords;

    public Probability() {
        percentProbabilityAndWords = new HashMap<>();
    }

    /**
     * @return Paragraph
     */
    public String getParagraph() {
        return paragraph;
    }

    /**
     * @param paragraph Paragraph to analyse
     */
    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
        getWordsWithProbability(paragraph);
    }

    /**
     * @return Queue words and probability
     */
    public Queue<Map.Entry<String, Integer>> getQueueWords() {
        return queueWords;
    }

    /**
     * @return true if probability loaded
     */
    public boolean isLoaded() {
        return queueWords != null && queueWords.size() > 0;
    }

    /**
     * Make list of words with random probability
     * @param paragraph Paragraph
     */
    private void getWordsWithProbability(String paragraph) {
        Pattern pattern = Pattern.compile("[A-zА-я]+");
        Matcher matcher = pattern.matcher(paragraph);
        while (matcher.find()) {
            String word = matcher.group();
            int percentProbability = getPercentProbabilityWord(word);
            // Слова которые повторятся в следующем абзаце с вероятность 0 - не учитываем
            if (percentProbability > 0) {
                percentProbabilityAndWords.put(word, percentProbability);
            }
        }

        queueWords = new LinkedList<>(percentProbabilityAndWords.entrySet());
    }

    /**
     * @param word Word for make probability
     * @return Random probability
     */
    private int getPercentProbabilityWord(String word) {
        return new Random().nextInt(100 + 1);
    }
}
