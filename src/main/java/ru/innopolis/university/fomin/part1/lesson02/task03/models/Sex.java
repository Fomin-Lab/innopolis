package ru.innopolis.university.fomin.part1.lesson02.task03.models;

public class Sex {
    public static String MAN = "MAN";
    public static String WOMAN = "WOMAN";

    protected String sex;

    public Sex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
