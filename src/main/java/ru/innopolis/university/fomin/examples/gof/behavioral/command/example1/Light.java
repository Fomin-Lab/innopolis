package ru.innopolis.university.fomin.examples.gof.behavioral.command.example1;

public class Light {
    protected boolean isOn = false;

    public void toggle() {
        if (isOn) {
            off();
            isOn = false;
        } else {
            on();
            isOn = true;
        }
    }

    private void on() {
        System.out.println("Light switched On.");
    }

    private void off() {
        System.out.println("Light switched Off.");
    }

    public boolean isOn() {
        return isOn;
    }
}
