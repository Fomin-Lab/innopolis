package ru.innopolis.university.fomin;

import java.util.Collections;
import java.util.List;

/*
    Реализация быстрой сортировки
 */
public class FastSort<T extends Sortable<T>> extends AlgorithmSort<T> {
    @Override
    protected void doSort(List<T> list) {
        fastSort(list);
    }

    /*
        Быстрая сортировка
     */
    private void fastSort(List<T> list) {
        Collections.sort(list);
    }
}
