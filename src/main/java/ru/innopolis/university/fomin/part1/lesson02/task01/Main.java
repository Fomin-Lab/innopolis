package ru.innopolis.university.fomin.part1.lesson02.task01;

import java.util.Random;

/**
 * Class performs the task conditions lesson02.task01
 */
public class Main {
    public static void main(String[] args) throws MyException {
        new HelloWorld();
        executeErrorCode(Throws.values()[new Random().nextInt(Throws.values().length)]);
    }

    /**
     * Perform error code by exception type
     * @param throwsEnum List of types exceptions
     * @throws MyException My type exception (Task01 condition)
     */
    private static void executeErrorCode(Throws throwsEnum) throws MyException {
        switch (throwsEnum) {
            case NULL_POINTER_EXCEPTION: {
                callNullPointerException();
                break;
            }
            case ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION: {
                callArrayIndexOutOfBoundsException();
                break;
            }
            case MY_EXCEPTION: {
                callMyException();
                break;
            }
        }
    }

    /**
     * Modelling call NullPointerException
     */
    private static void callNullPointerException() {
        String str = createString();
        byte[] bytes = str.getBytes();
    }

    /**
     * Modelling call ArrayIndexOutOfBoundsException
     */
    private static void callArrayIndexOutOfBoundsException() {
        int[] array = new int[3];
        int value = array[33];
    }

    /**
     * Modelling call MyException
     */
    private static void callMyException() throws MyException {
        throw new MyException("Возникла моя ошибка");
    }

    private static String createString() {
        return null;
    }
}
