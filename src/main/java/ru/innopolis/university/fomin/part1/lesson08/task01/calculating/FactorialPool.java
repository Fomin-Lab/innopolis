package ru.innopolis.university.fomin.part1.lesson08.task01.calculating;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculating factorial by thread pool
 */
public class FactorialPool {
    /**
     * Divider for calculate count threads
     */
    private static final int DIVIDER = 10;

    /**
     * Result calculation
     */
    private volatile BigInteger result;

    /**
     * List of threads need for calculation
     */
    private final List<Thread> threads;

    /**
     * Source value
     */
    private final int value;

    /**
     * Locker object for synchronized
     */
    private final Object locker = new Object();

    /**
     * @param value Source value
     */
    public FactorialPool(int value) {
        result = BigInteger.valueOf(1);
        threads = new ArrayList<>();
        this.value = value;
    }

    /**
     * @return Calculated factorial
     */
    public BigInteger calculate() {
        calculateFactorial();
        return result;
    }

    /**
     * @return Number of threads
     */
    public int countThreads() {
        return threads.size();
    }

    /**
     * Calculating factorial with create threads
     */
    private void calculateFactorial() {
        int parts = value / DIVIDER;
        int step = parts == 0 ? value : DIVIDER;

        /*
            Например: На вход получаем число 9, DIVIDER = 3
            Тогда создаем 3 потока.
            Первый поток рассчитывает факториал числа 3
            Второй поток рассчитывает факториал числа 6, исключая факториал 3 (т.е. 4*5*6)
            Третий поток рассчитывает факториал числа 9, исключая факториал 6 (т.е. 7*8*9)
            По завершению все значения "склеиваются" т.е. перемножаются, результат записывается в переменную this.result
         */
        for (int i = 1; i <= value; i += step) {
            int end = (i + step) - 1;
            if (end > value) end = value;
            Thread t = createTread(i, end);
            t.start();
            threads.add(t);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param startValue Start value for calculate factorial
     * @param endValue End value for calculate factorial
     * @return Created thread
     */
    private Thread createTread(final int startValue, final int endValue) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (locker) {
                    result = result.multiply(HardMath.factorial(startValue, endValue));
                }
            }
        });
    }
}
