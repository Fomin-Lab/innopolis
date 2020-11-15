package ru.innopolis.university.fomin.examples.gof.behavioral.mediator.example1;

public class TurnOnAllLightsCommand implements Command {
    private Mediator med;

    public TurnOnAllLightsCommand(Mediator mediator) {
        this.med = mediator;
    }

    @Override
    public void execute() {
        med.turnOnAllLights();
    }
}
