package ru.innopolis.university.fomin;

public class Main {
    public static void main(String[] args) throws MyException {
        System.out.println("Hello world!");

        // Моделирование ошибки NullPointerException
        try {
            String str = createString();
            byte[] bytes = str.getBytes();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        // Моделирование ошибки ArrayIndexOutOfBoundsException
        try {
            int[] array = new int[3];
            int value = array[33];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        throw new MyException();
    }

    private static String createString() {
        return null;
    }

    public static class MyException extends Exception {

    }
}
