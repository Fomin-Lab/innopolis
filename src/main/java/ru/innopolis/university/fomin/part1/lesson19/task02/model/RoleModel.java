package ru.innopolis.university.fomin.part1.lesson19.task02.model;

public class RoleModel extends JdbcModel {
    private int id;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
