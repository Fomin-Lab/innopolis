package ru.innopolis.university.fomin.examples.gof.behavioral.state.example1;

public class FanHighState extends State {
    private Fan fan;

    public FanHighState(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void handleRequest() {
        System.out.println("Turning fan on off.");
        fan.setState(fan.getFanOffState());
    }

    public String toString() {
        return "Fan is high";
    }
}
