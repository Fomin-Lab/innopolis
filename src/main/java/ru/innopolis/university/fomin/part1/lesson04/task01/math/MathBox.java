package ru.innopolis.university.fomin.part1.lesson04.task01.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MathBox class
 *
 */
public class MathBox {
    protected List<Number> numbers;

    /**
     * Initial collection in field class
     * @param numbers Array of numbers
     */
    public MathBox(Number[] numbers) {
        this.numbers = new ArrayList<>();
        this.numbers.addAll(Arrays.asList(numbers));
    }

    /**
     * @return Sum of all number in collection
     */
    public Number summator() {
        Number result = 0;
        for (Number number : numbers) {
            result = result.doubleValue() + number.doubleValue();
        }
        return result;
    }

    /**
     * @param divider Value for divide numbers in collection
     * @return Divided numbers in array
     */
    public Number[] splitter(int divider) {
        Number[] result = new Number[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            Number number = numbers.get(i);
            result[i] = number.doubleValue() / divider;
        }
        return result;
    }

    /**
     * @param value Value for delete in collection
     */
    public void remove(Integer value) {
        numbers.remove(value);
    }
}
