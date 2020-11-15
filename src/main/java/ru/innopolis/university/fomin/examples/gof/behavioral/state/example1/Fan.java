package ru.innopolis.university.fomin.examples.gof.behavioral.state.example1;

public class Fan {
    private State fanOffState;
    private State fanLowState;
    private State fanMedState;
    private State fanHighState;

    private State currentState;

    public Fan() {
        fanOffState = new FanOffState(this);
        fanLowState = new FanLowState(this);
        fanMedState = new FanMedState(this);
        fanHighState = new FanHighState(this);

        currentState = fanOffState;
    }

    public State getFanOffState() {
        return fanOffState;
    }

    public State getFanLowState() {
        return fanLowState;
    }

    public State getFanMedState() {
        return fanMedState;
    }

    public State getFanHighState() {
        return fanHighState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setState(State currentState) {
        this.currentState = currentState;
    }

    public void pullChain() {
        currentState.handleRequest();
    }

    public String toString() {
        return currentState.toString();
    }
}
