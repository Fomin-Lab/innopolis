package ru.innopolis.university.fomin.examples.gof.behavioral.command.example3;

import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void push(Command command) {
        history.push(command);
    }

    public Command pop() {
        if (history.empty()) {
            return null;
        }
        return history.pop();
    }
}
