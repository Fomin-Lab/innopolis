package ru.innopolis.university.fomin.math;

import ru.innopolis.university.fomin.box.ObjectBox;

import java.util.Arrays;

public class MathBox extends ObjectBox {
    public MathBox(Number[] numbers) {
        super();
        this.objectList.addAll(Arrays.asList(numbers));
    }

    public int summator() {
        int result = 0;
        for (Object object : objectList) {
            Number number = (Number) object;
            result = result + number.get();
        }
        return result;
    }

    public void splitter(int divider) {
        for (Object object : objectList) {
            Number number = (Number) object;
            number.divide(divider);
        }
    }

    public void remove(Integer value) {
        Number number = new Number(value);
        int index = objectList.indexOf(number);
        objectList.remove(index);
    }

    @Override
    public void addObject(Object object) throws IncompatibleTypesException {
        if (!(object instanceof Number)) throw new IncompatibleTypesException();
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
