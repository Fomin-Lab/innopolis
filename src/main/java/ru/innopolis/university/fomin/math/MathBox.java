package ru.innopolis.university.fomin.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathBox {
    List<Number> numbers;

    public MathBox(Number[] numbers) {
        this.numbers = new ArrayList<Number>();
        this.numbers.addAll(Arrays.asList(numbers));
    }

    public int summator() {
        int result = 0;
        for (Number number : numbers) {
            result = result + number.get();
        }
        return result;
    }

    public void splitter(int divider) {
        for (Number number : numbers) {
            number.divide(divider);
        }
    }

    public void remove(Integer value) {
        Number number = new Number(value);
        int index = numbers.indexOf(number);
        numbers.remove(index);
    }
}
