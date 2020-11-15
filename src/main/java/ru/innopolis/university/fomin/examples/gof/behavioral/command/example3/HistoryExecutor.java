package ru.innopolis.university.fomin.examples.gof.behavioral.command.example3;

// decorator
public class HistoryExecutor extends Command {
    protected Command original;
    protected CommandHistory history;

    public HistoryExecutor(Command original, CommandHistory history) {
        super(original.app, original.editor);
        this.original = original;
        this.history = history;
    }

    @Override
    public boolean execute() {
        boolean executeResult = original.execute();

        if (executeResult) {
            System.out.println(original.getClass().getSimpleName() + " saved to history.");
            history.push(original);
        }

        return executeResult;
    }
}
