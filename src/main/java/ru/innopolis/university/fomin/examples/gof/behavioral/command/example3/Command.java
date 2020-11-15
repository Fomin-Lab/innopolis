package ru.innopolis.university.fomin.examples.gof.behavioral.command.example3;

public abstract class Command {
    protected Application app;
    protected Editor editor;
    protected String backup;

    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    public void saveBackup() {
        backup = editor.getText();
    }

    public void undo() {
        editor.setText(backup);
    }

    public abstract boolean execute();
}
