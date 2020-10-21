package ru.innopolis.university.fomin.part1.lesson08.task01;

import ru.innopolis.university.fomin.ExecuteTimer;
import ru.innopolis.university.fomin.part1.lesson08.task01.calculating.FactorialCallable;
import ru.innopolis.university.fomin.part1.lesson08.task01.calculating.FactorialPool;
import ru.innopolis.university.fomin.part1.lesson08.task01.calculating.HardMath;

import java.util.*;
import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * Class performs the task conditions lesson08.task01
 */
public class Main {
    /**
     * Max number of digits for printing BigInteger value
     * Needed because if print very big value in console then deleted first lines
     */
    private static final int BIGINTEGER_MAX_SIZE = 1000;

    public static void main(String[] args){
        int value = 173984;
        calculationMainThread(value);
        calculationThreadPool(value);
        calculationExecutorService(value);
    }

    /**
     * Demonstration calculating factorial for one value in main thread
     *
     * @param value Value for calculation
     */
    private static void calculationMainThread(int value) {
        ExecuteTimer.startTimer();
        BigInteger resultInSingleThread = calculateFactorialInSingleMainThread(value);
        ExecuteTimer.endTimer();

        System.out.println("Результат в одном потоке получен через " + ExecuteTimer.getTime());
        printBigInteger(resultInSingleThread);
        System.out.println();
    }

    /**
     * Demonstration calculating factorial for one value by thread pool
     *
     * @param value Value for calculation
     */
    private static void calculationThreadPool(int value) {
        FactorialPool factorialPool = new FactorialPool(value);
        ExecuteTimer.startTimer();
        BigInteger resultInPoolThreads = factorialPool.calculate();
        ExecuteTimer.endTimer();

        System.out.println("Результат используя пул-потоков был получен через " + ExecuteTimer.getTime());
        System.out.println("Было создано потоков для расчета: " + factorialPool.countThreads());
        printBigInteger(resultInPoolThreads);
    }

    /**
     * Demonstration calculating factorial for other values by executor service
     *
     * @param value Value for calculation
     */
    private static void calculationExecutorService(final int value) {
        ExecutorService service = Executors.newCachedThreadPool();

        // Создаём 5 задач для расчета факториала
        List<Callable<BigInteger>> tasks = new ArrayList<>();
        tasks.add(new FactorialCallable(9));
        tasks.add(new FactorialCallable(12));
        tasks.add(new FactorialCallable(111));
        tasks.add(new FactorialCallable(value));
        tasks.add(new FactorialCallable(3));

        List<Future<BigInteger>> futures = new ArrayList<>();

        for (Callable<BigInteger> task : tasks) {
            futures.add(service.submit(task));
        }

        try {
            System.out.println("\nРасчет факториалов используя executor service");
            for (Future<BigInteger> future : futures) {
                printBigInteger(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }

    /**
     * Simple calculating factorial in one thread
     *
     * @param value Value for calculation
     * @return Factorial
     */
    private static BigInteger calculateFactorialInSingleMainThread(final int value) {
        return HardMath.factorial(1, value);
    }

    /**
     * Printing biginteger value with max length
     *
     * @param value BigInteger for printing
     */
    private static void printBigInteger(BigInteger value) {
        if (value.toString().length() > BIGINTEGER_MAX_SIZE) {
            System.out.println(value.toString().substring(0, BIGINTEGER_MAX_SIZE) + "...");
        } else {
            System.out.println(value);
        }
    }
}
