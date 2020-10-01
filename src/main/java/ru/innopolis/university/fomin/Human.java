package ru.innopolis.university.fomin;

public interface Human extends Comparable<Human> {
    String getName();
    int getAge();
    String getSex();
}
