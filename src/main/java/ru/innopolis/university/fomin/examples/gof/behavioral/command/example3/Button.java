package ru.innopolis.university.fomin.examples.gof.behavioral.command.example3;

public class Button {
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void click() {
        if (command != null) {
            command.execute();
        }
    }
}
