package ru.innopolis.university.fomin.examples.gof.behavioral.state.example1;

public class StateProblemDemo {

    public static void main(String[] args) {
        ProblemFan fan = new ProblemFan();
        System.out.println(fan);
        fan.pullChain();
        System.out.println(fan);
        fan.pullChain();
        System.out.println(fan);
        fan.pullChain();
        System.out.println(fan);
    }

}

class ProblemFan {

    final static int OFF = 0;
    final static int LOW = 1;
    final static int MED = 2;

    int state = OFF;

    public ProblemFan() {
    }

    // many if else statements - it's a problem
    public void pullChain() {
        if (state == OFF) {
            System.out.println("Turning fan on to low.");
            state = LOW;
        } else if (state == LOW) {
            System.out.println("Turning fan med.");
            state = MED;
        } else if (state == MED) {
            System.out.println("Turning fan off.");
            state = OFF;
        }
    }

    public String toString() {
        if (state == OFF) {
            return "Fan is off";
        } else if (state == LOW) {
            return "Fan is on low";
        } else if (state == MED) {
            return "Fan is on med";
        }
        return "Invalida state.";
    }
}
