package ru.innopolis.university.fomin.part1.lesson19.task01;

import ru.innopolis.university.fomin.part1.lesson19.task01.connection.ConnectionFactory;
import ru.innopolis.university.fomin.part1.lesson19.task01.connection.DatabaseType;
import ru.innopolis.university.fomin.part1.lesson19.task01.scheme.BlogDbScheme;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Util for create empty tables in postgre database
 */
public class DatabaseUtil {
    /**
     * Username for create connection with the database
     */
    public static final String USERNAME = "postgres";

    /**
     * Password for create connection with the database
     */
    public static final String PASSWORD = "qwerty";

    /**
     * Name of database
     */
    public static final String DB_NAME = BlogDbScheme.NAME;

    /**
     * Address to connect
     */
    private static final String ADDRESS = "localhost";
    /**
     * Port to connect
     */
    private static final String PORT = "5433";

    /**
     * Entry point
     * @param args Input arguments
     */
    public static void main(String[] args) {
        renewDatabase();
        renewTables();
        insertSomeLines();
    }

    /**
     * Create/Recreate blog database
     */
    public static void renewDatabase() {
        try (Connection connection = ConnectionFactory.getConnection(DatabaseType.DEFAULT);
             Statement statement = connection.createStatement();
        ) {
            // База данных
            statement.execute("DROP DATABASE IF EXISTS " + DB_NAME + ";\n"
                    + "CREATE DATABASE " + DB_NAME + ";\n"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create/Recreate blog tables
     */
    public static void renewTables() {
        try (Connection connection = ConnectionFactory.getConnection(DatabaseType.BLOG);
             Statement statement = connection.createStatement();
        ) {
            // Таблица ролей
            statement.execute("DROP TABLE IF EXISTS bg_roles;\n"
                    + "CREATE TABLE bg_roles (\n"
                    + "id bigserial primary key,\n"
                    + "title varchar (100) NOT NULL)"
            );

            // Таблица статей
            statement.execute("DROP TABLE IF EXISTS bg_articles;\n"
                    + "CREATE TABLE bg_articles (\n"
                    + "id bigserial primary key,\n"
                    + "title varchar (100) NOT NULL,\n"
                    + "content text,\n"
                    + "author varchar (50),\n"
                    + "likes int)"
            );

            // Таблица пользователей
            statement.execute("DROP TABLE IF EXISTS bg_users;\n"
                    + "CREATE TABLE bg_users (\n"
                    + "id bigserial primary key,\n"
                    + "login varchar (100) NOT NULL,\n"
                    + "name varchar (100),\n"
                    + "rate int)"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert some lines into the tables
     */
    public static void insertSomeLines() {
        try (Connection connection = ConnectionFactory.getConnection(DatabaseType.BLOG);
             Statement statement = connection.createStatement();
        ) {
            // Таблица ролей

            // Таблица статей
            statement.execute("insert into bg_articles (title, content, author)\n" +
                    "        values ('Статья 1', 'Текст статьи', 'Иванов')");
            statement.execute("insert into bg_articles (title, content, author)\n" +
                    "        values ('Статья 2', 'Текст статьи 2', 'Веточкин')");
            statement.execute("insert into bg_articles (title, content, author)\n" +
                    "        values ('Статья 3', 'Текст статьи 3', 'Камушкин')");
            statement.execute("insert into bg_articles (title, content, author)\n" +
                    "        values ('Статья 4', 'Текст статьи 4', 'Заборчик')");
            statement.execute("insert into bg_articles (title, content, author)\n" +
                    "        values ('Статья 5', 'Текст статьи 5', 'Заплесневейко')");

            // Таблица пользователей
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param dbName Database name. May be null.
     * @return Connection string
     */
    public static String getConnectionString(String dbName) {
        String result = "jdbc:postgresql://" + ADDRESS + ":" + PORT + "/";
        if (dbName != null) {
            result += dbName;
        }
        return result;
    }
}