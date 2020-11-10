package ru.innopolis.university.fomin.examples.gof.creational.builder.example1;

public class BuilderDemo {
    public static void main(String[] args) {
        User user = new User.Builder("Jhon", "Thomson")
                .withAge(25)
                .withPhone("911")
                .build();
        System.out.println(user);
    }
}
