package ru.innopolis.university.fomin.examples.gof.behavioral.command.example3;

public class Editor {
    protected String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSelection() {
        System.out.println("Вернуть выбранный текст");
        return "Вернуть выбранный текст";
    }

    public void deleteSelection() {
        System.out.println("Удалить выбранный текст");
    }

    public void replaceSelection(String text) {
        System.out.println("Вставить текст из буфера обмена в текущей позиции.");
    }
}
