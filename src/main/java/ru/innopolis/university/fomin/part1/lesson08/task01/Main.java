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

    public static void main(String[] args){
        int value = 120000;
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
        printBigInteger(resultInSingleThread, 1000);
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
        printBigInteger(resultInPoolThreads, 1000);
    }

    /**
     * Demonstration calculating factorial for other values by executor service
     *
     * @param value Value for calculation
     */
    private static void calculationExecutorService(final int value) {
        ExecutorService service = Executors.newCachedThreadPool();

        // Создаём 5 задач для расчета факториала
        List<Callable<BigInteger>> tasks = new ArrayList<Callable<BigInteger>>() {{
            add(new FactorialCallable(9));
            add(new FactorialCallable(12));
            add(new FactorialCallable(111));
            add(new FactorialCallable(value));
            add(new FactorialCallable(3));
        }};

        List<Future<BigInteger>> futures = new ArrayList<>();

        for (Callable<BigInteger> task : tasks) {
            futures.add(service.submit(task));
        }

        try {
            System.out.println("\nРасчет факториалов используя executor service");
            for (Future<BigInteger> future : futures) {
                printBigInteger(future.get(), 1000);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    /**
     * @param value Value for calculation
     * @return Factorial
     */
    private static BigInteger calculateFactorialInSingleMainThread(final int value) {
        return HardMath.factorial(1, value);
    }

    private static void printBigInteger(BigInteger value, int bound) {
        if (value.toString().length() > bound) {
            System.out.println(value.toString().substring(0, bound) + "...");
        } else {
            System.out.println(value);
        }
    }
}
