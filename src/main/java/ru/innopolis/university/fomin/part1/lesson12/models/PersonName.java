package ru.innopolis.university.fomin.part1.lesson12.models;

import ru.innopolis.university.fomin.part1.lesson02.task03.models.Sex;

/**
 * Composition of name and gender
 */
public class PersonName {
    protected String name;
    protected Sex sex;

    public PersonName(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
