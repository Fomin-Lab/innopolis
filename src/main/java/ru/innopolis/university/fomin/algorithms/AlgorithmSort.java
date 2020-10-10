package ru.innopolis.university.fomin.algorithms;

import java.util.List;

/*
    Базовый абстрактный класс сортировки
 */
public abstract class AlgorithmSort<T extends Sortable<T>> {
    private long timeStart = 0;
    private long timeEnd = 0;

    public void sort(List<T> list) {
        startTimer();
        doSort(list);
        endTimer();
    }

    protected abstract void doSort(List<T> list);

    private void startTimer() {
        timeStart = System.currentTimeMillis();
    }

    private void endTimer() {
        timeEnd = System.currentTimeMillis();
    }

    public long getTime() {
        return timeEnd - timeStart;
    }
}
