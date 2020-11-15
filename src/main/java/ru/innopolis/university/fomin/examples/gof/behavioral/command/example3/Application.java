package ru.innopolis.university.fomin.examples.gof.behavioral.command.example3;

import java.util.List;

public class Application {
    protected String clipboard;
    protected List<Editor> editors;
    protected Editor activeEditor;
    protected CommandHistory history;

    public static void main(String[] args) {
        Application app = new Application();
        app.activeEditor = new Editor();
        app.history = new CommandHistory();
        app.createUI();
    }

    protected void createUI() {
        Button copyButton = new Button();
        copyButton.setCommand(new HistoryExecutor(new CopyCommand(this, activeEditor), history));
        copyButton.click();

        Button cutCommand = new Button();
        cutCommand.setCommand(new HistoryExecutor(new CutCommand(this, activeEditor), history));
        cutCommand.click();

        Button pasteButton = new Button();
        pasteButton.setCommand(new HistoryExecutor(new PasteCommand(this, activeEditor), history));
        pasteButton.click();

        Button undoButton = new Button();
        undoButton.setCommand(new HistoryExecutor(new UndoCommand(this, activeEditor), history));
        undoButton.click();
    }

    public String getClipboard() {
        return clipboard;
    }

    public void setClipboard(String clipboard) {
        this.clipboard = clipboard;
    }

    public void undo() {
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}
