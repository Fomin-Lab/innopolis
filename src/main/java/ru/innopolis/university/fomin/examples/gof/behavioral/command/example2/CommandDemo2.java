package ru.innopolis.university.fomin.examples.gof.behavioral.command.example2;

import ru.innopolis.university.fomin.examples.gof.behavioral.command.example1.Command;
import ru.innopolis.university.fomin.examples.gof.behavioral.command.example1.Light;
import ru.innopolis.university.fomin.examples.gof.behavioral.command.example1.ToggleCommand;

import java.util.List;
import java.util.ArrayList;

// client
public class CommandDemo2 {
    public static void main(String[] args) {
        Light bedroomLight = new Light();
        Light kitchenLight = new Light();

        Switch lightSwitch = new Switch();

        Command toggleCommandB = new ToggleCommand(bedroomLight);
        Command toggleCommandK = new ToggleCommand(kitchenLight);
        lightSwitch.storeCommand(toggleCommandB);
        lightSwitch.storeCommand(toggleCommandK);

        List<Light> lights = new ArrayList<>();
        lights.add(kitchenLight);
        lights.add(bedroomLight);

        Command allLightsCommand = new AllLightsOffCommand(lights);
        lightSwitch.storeCommand(allLightsCommand);

        System.out.println("=======================");
        lightSwitch.executeCommand();
    }
}
