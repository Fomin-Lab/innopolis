package ru.innopolis.university.fomin.examples.gof.behavioral.command.example3;

public class CopyCommand extends Command {
    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public boolean execute() {
        app.setClipboard(editor.getSelection());
        return false;
    }
}
