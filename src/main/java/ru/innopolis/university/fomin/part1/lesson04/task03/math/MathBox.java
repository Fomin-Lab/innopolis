package ru.innopolis.university.fomin.part1.lesson04.task03.math;

import ru.innopolis.university.fomin.part1.lesson04.task03.box.ObjectBox;

import java.util.Arrays;

/**
 * MathBox class
 *
 */
public class MathBox extends ObjectBox {
    /**
     * Initial collection in field class
     * @param numbers Array of numbers
     */
    public MathBox(Number[] numbers) {
        super();
        this.objectList.addAll(Arrays.asList(numbers));
    }

    /**
     * @return Sum of all number in collection
     */
    public Number summator() {
        Number result = 0;
        for (Object object : objectList) {
            Number number = (Number) object;
            result = result.doubleValue() + number.doubleValue();
        }
        return result;
    }

    /**
     * @param divider Value for divide numbers in collection
     * @return Divided numbers in array
     */
    public Number[] splitter(int divider) {
        Number[] result = new Number[objectList.size()];
        for (int i = 0; i < objectList.size(); i++) {
            Number number = (Number) objectList.get(i);
            result[i] = number.doubleValue() / divider;
        }
        return result;
    }

    /**
     * @param value Value for delete in collection
     */
    public void remove(Integer value) {
        objectList.remove(value);
    }

    @Override
    public void addObject(Object object) throws IncompatibleTypesException {
        if (!(object instanceof Number)) throw new IncompatibleTypesException("Объект не является потомком класса Number");
        super.addObject(object);
    }

    @Override
    public void removeObject(Object object) {
        super.removeObject(object);
    }

    @Override
    public void dump() {
        super.dump();
    }
}
