package ru.innopolis.university.fomin.examples.gof.behavioral.command.example2;

import ru.innopolis.university.fomin.examples.gof.behavioral.command.example1.Command;
import ru.innopolis.university.fomin.examples.gof.behavioral.command.example1.Light;

import java.util.List;

public class AllLightsOffCommand implements Command {
    private List<Light> lights;

    public AllLightsOffCommand(List<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        for (Light light : lights) {
            if (light.isOn()) {
                light.toggle();
            }
        }
    }
}
