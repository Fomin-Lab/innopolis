package ru.innopolis.university.fomin;

import java.util.Random;

public class Utils {
    public static int getRandomValue(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
