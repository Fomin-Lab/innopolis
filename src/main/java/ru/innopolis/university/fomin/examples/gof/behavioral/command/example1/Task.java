package ru.innopolis.university.fomin.examples.gof.behavioral.command.example1;

public class Task implements Runnable {
    protected int num1;
    protected int num2;

    public Task(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        System.out.println(num1 * num2);
    }
}
