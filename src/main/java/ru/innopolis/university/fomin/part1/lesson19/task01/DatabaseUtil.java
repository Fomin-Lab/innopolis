package ru.innopolis.university.fomin.part1.lesson19.task01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Util for create empty tables in postgre database
 */
public class DatabaseUtil {
    /**
     * Entry point
     * @param args Input arguments
     */
    public static void main(String[] args) {
        renewDatabase();
        renewTables();
    }

    /**
     * Create/Recreate blog database
     */
    public static void renewDatabase() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/",
                "postgres",
                "qwerty");
             Statement statement = connection.createStatement();
        ) {
            // База данных
            statement.execute("DROP DATABASE IF EXISTS db_blog;\n"
                    + "CREATE DATABASE db_blog;\n"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create/Recreate blog tables
     */
    public static void renewTables() {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5433/db_blog",
                "postgres",
                "qwerty");
             Statement statement = connection.createStatement();
        ) {
            // Таблица ролей
            statement.execute("DROP TABLE IF EXISTS bg_roles;\n"
                    + "CREATE TABLE bg_roles (\n"
                    + "id bigserial primary key,\n"
                    + "name varchar (100) NOT NULL)"
            );

            // Таблица статей
            statement.execute("DROP TABLE IF EXISTS bg_articles;\n"
                    + "CREATE TABLE bg_articles (\n"
                    + "id bigserial primary key,\n"
                    + "title varchar (100) NOT NULL,\n"
                    + "content text,\n"
                    + "author varchar (50))"
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
}