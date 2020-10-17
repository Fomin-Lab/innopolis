package ru.innopolis.university.fomin.part1.lesson08.task01.calculating;

import java.math.BigInteger;
import java.util.concurrent.Callable;

/**
 * Factorial callable for executor service
 */
public class FactorialCallable implements Callable<BigInteger> {
    protected int sourceValue;

    public FactorialCallable(int value) {
        this.sourceValue = value;
    }

    @Override
    public BigInteger call() {
        return HardMath.factorial(1, sourceValue);
    }
}
