package ru.innopolis.university.fomin;

import java.util.List;

/*
    Базовый абстрактный класс сортировки
 */
public abstract class HumanSort<T extends Human> {
    protected long timeStart = 0;
    protected long timeEnd = 0;

    protected abstract void doSort(List<T> list);

    protected void swap(Object[] array, int ind1, int ind2) {
        Object tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    protected void startTimer() {
        timeStart = System.currentTimeMillis();
    }

    protected void endTimer() {
        timeEnd = System.currentTimeMillis();
    }

    public long getTime() {
        return timeEnd - timeStart;
    }
}
