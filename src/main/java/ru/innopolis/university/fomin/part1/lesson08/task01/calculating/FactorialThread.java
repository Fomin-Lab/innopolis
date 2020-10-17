package ru.innopolis.university.fomin.part1.lesson08.task01.calculating;

import java.math.BigInteger;

/**
 * Thread for calculation factorial
 * (not used)
 */
public class FactorialThread extends Thread {
    protected BigInteger result;
    protected int sourceValue;

    public FactorialThread(int value) {
        result = BigInteger.valueOf(1);
        this.sourceValue = value;
    }

    @Override
    public void run() {
        result = HardMath.factorial(1, sourceValue);
    }

    public BigInteger getResult() {
        return result;
    }
}
