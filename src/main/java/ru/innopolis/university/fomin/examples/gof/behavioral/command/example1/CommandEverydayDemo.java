package ru.innopolis.university.fomin.examples.gof.behavioral.command.example1;

public class CommandEverydayDemo {
    public static void main(String[] args) {
        Task task1 = new Task(10, 12); // encapsulates request
        Task task2 = new Task(11, 13);

        Thread thread1 = new Thread(task1);
        thread1.start(); // invoker

        Thread thread2 = new Thread(task2);
        thread2.start();
    }
}
