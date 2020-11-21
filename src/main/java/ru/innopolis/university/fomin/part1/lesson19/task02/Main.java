package ru.innopolis.university.fomin.part1.lesson19.task02;

import ru.innopolis.university.fomin.part1.lesson19.task02.dao.ArticleController;
import ru.innopolis.university.fomin.part1.lesson19.task02.jdbc_connection.ConnectionManager;
import ru.innopolis.university.fomin.part1.lesson19.task02.jdbc_connection.PostgreConnectionManager;

public class Main {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new PostgreConnectionManager();
        ArticleController articleController = new ArticleController(
                connectionManager.getConnection()
        );
        articleController.getAll().forEach(System.out::println);
    }
}
