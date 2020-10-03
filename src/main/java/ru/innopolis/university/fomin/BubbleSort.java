package ru.innopolis.university.fomin;

import java.util.List;

/*
    Реализация сортировки пузырьком
 */
public class BubbleSort<T extends Sortable<T>> extends AlgorithmSort<T> {
    @Override
    protected void doSort(List<T> list) {
        Object[] result = bubbleSort(list);
        list.clear();
        for (int i = 0; i < result.length; i++) {
            list.add((T) result[i]);
        }
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

    protected void swap(Object[] array, int ind1, int ind2) {
        Object tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }
}
