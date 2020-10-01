package ru.innopolis.university.fomin;

import java.util.Collections;
import java.util.List;

/*
    Реализация быстрой сортировки
 */
public class FastHumanSort<T extends Human> extends HumanSort<T> {
    @Override
    protected void doSort(List<T> list) {
        startTimer();
        fastSort(list);
        endTimer();
    }

    /*
        Быстрая сортировка
     */
    private void fastSort(List<T> list) {
        Collections.sort(list);
    }
}
