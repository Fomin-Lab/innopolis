package ru.innopolis.university.fomin.examples.gof.behavioral.command.example2;

import ru.innopolis.university.fomin.examples.gof.behavioral.command.example1.Command;

import java.util.List;
import java.util.ArrayList;

public class Switch {
    private List<Command> commandList = new ArrayList<>();

    public void storeCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommand() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
