package ru.innopolis.university.fomin;

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
