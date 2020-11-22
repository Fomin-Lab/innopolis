package ru.innopolis.university.fomin.part1.lesson19.task02;

import ru.innopolis.university.fomin.part1.lesson19.task02.dao.ArticleController;
import ru.innopolis.university.fomin.part1.lesson19.task02.dao.RoleController;
import ru.innopolis.university.fomin.part1.lesson19.task02.dao.UserController;
import ru.innopolis.university.fomin.part1.lesson19.task02.jdbc_connection.ConnectionManager;
import ru.innopolis.university.fomin.part1.lesson19.task02.jdbc_connection.PostgreConnectionManager;
import ru.innopolis.university.fomin.part1.lesson19.task02.model.ArticleModel;
import ru.innopolis.university.fomin.part1.lesson19.task02.model.UserModel;

public class Main {
    public static void main(String[] args) {
        ConnectionManager connectionManager = new PostgreConnectionManager();

        System.out.println("Статьи: ");
        ArticleController articleController = new ArticleController(
                connectionManager.getConnection()
        );
        articleController.getAll().forEach(System.out::println);

        System.out.println("\nРоли: ");
        RoleController roleController = new RoleController(
                connectionManager.getConnection()
        );
        roleController.getAll().forEach(System.out::println);

        System.out.println("\nПользователи: ");
        UserController userController = new UserController(
                connectionManager.getConnection()
        );
        userController.getAll().forEach(System.out::println);

        System.out.println("\nПолучаем роль по идентификатору");
        System.out.println(roleController.getEntityById(2));

        System.out.println("\nУдаляем запись по айди");
        System.out.println("Успешно: " + userController.delete(3));

        System.out.println("\nСоздаём новую статью");
        ArticleModel articleModel = new ArticleModel("Cnfsd", "asdsad", 2, 2);
        System.out.println("Присвоенный айди: " + articleController.create(articleModel));

        System.out.println("\nСоздаём нового пользователя");
        UserModel userModel = new UserModel("Пчелкина", "pchelkina", 3, 2);
        System.out.println("Присвоенный айди: " + userController.create(userModel));

        System.out.println("\nОбновляем пользователя");
        UserModel userModel2 = new UserModel("Кудряшкина", "kudryashkina", 2, 4);
        userModel2.setId(1);
        System.out.println("Успешно: " + userController.update(userModel2));
    }
}
