package ru.innopolis.university.fomin.part1.lesson08.task01.calculating;

import java.math.BigInteger;

/**
 * Mathematic operations
 */
public class HardMath {
    /**
     * @param start Start value for calculate factorial
     * @param n End value for calculate factorial
     * @return Calculated factorial
     */
    public static BigInteger factorial(int start, int n) {
        BigInteger result = BigInteger.valueOf(start);
        for (int i = start; i < n; i++){
            result = result.multiply(BigInteger.valueOf(i + 1));
        }
        return result;
    }
}
