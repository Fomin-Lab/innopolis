package ru.innopolis.university.fomin;

import java.util.List;

/*
    Реализация сортировки пузырьком
 */
public class BubbleHumanSort<T extends Human> extends HumanSort<T> {
    @Override
    protected void doSort(List<T> list) {
        startTimer();
        Object[] result = bubbleSort(list);
        list.clear();
        for (int i = 0; i < result.length; i++) {
            list.add((T) result[i]);
        }
        endTimer();
    }

    /*
        Простейшая сортировка (Пузырьком)
     */
    private Object[] bubbleSort(List<T> list) {
        Object[] array =  list.toArray();
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < array.length; i++) {
                T a = (T) array[i];
                T b = (T) array[i - 1];
                if (a.compareTo(b) < 0) {
                    swap(array, i, i-1);
                    needIteration = true;
                }
            }
        }
        return array;
    }
}
