package ru.innopolis.university.fomin;

import ru.innopolis.university.fomin.math.MathBox;
import ru.innopolis.university.fomin.math.Number;

public class Main {
    public static void main(String[] args) {
        MathBox mathBox = new MathBox(new Number[] { new Number(2), new Number(4) });
        mathBox.dump();
    }
}
