package ru.innopolis.university.fomin.examples.gof.behavioral.mediator.example1;

public class TurnOffAllLightsCommand implements Command {
    private Mediator med;

    public TurnOffAllLightsCommand(Mediator mediator) {
        this.med = mediator;
    }

    @Override
    public void execute() {
        med.turnOffAllLights();
    }
}
