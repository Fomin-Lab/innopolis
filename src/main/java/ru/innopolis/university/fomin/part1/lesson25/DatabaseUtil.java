package ru.innopolis.university.fomin.part1.lesson25;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.university.fomin.part1.lesson25.connection.ConnectionFactory;
import ru.innopolis.university.fomin.part1.lesson25.connection.DatabaseType;
import ru.innopolis.university.fomin.part1.lesson25.scheme.BlogDbScheme;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Util for create empty tables in postgre database
 */
public class DatabaseUtil {
    /**
     * Slf4j wrapper
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseUtil.class);

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
     * host.docker.internal - this address from docker container to localhost
     */
    private static final String ADDRESS = "host.docker.internal";

    /**
     * Port to connect
     */
    private static final String PORT = "5433";

    /**
     * Entry point
     * Create/Recreate database and tables
     *
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
        LOGGER.trace("start renewDatabase");

        try (Connection connection = ConnectionFactory.getConnection(DatabaseType.DEFAULT);
             Statement statement = connection.createStatement();
        ) {
            // База данных
            LOGGER.info("DROP/CREATE database " + DB_NAME);
            statement.execute("DROP DATABASE IF EXISTS " + DB_NAME + ";\n"
                    + "CREATE DATABASE " + DB_NAME + ";\n"
            );
        } catch (SQLException e) {
            LOGGER.error("sql exception", e);
        }
    }

    /**
     * Create/Recreate blog tables
     */
    public static void renewTables() {
        LOGGER.trace("start renewTables");

        try (Connection connection = ConnectionFactory.getConnection(DatabaseType.BLOG);
             Statement statement = connection.createStatement();
        ) {
            // Таблица ролей
            LOGGER.info("DROP/CREATE table bg_roles");
            statement.execute("DROP TABLE IF EXISTS bg_roles;\n"
                    + "CREATE TABLE bg_roles (\n"
                    + "id bigserial primary key,\n"
                    + "title varchar (100) NOT NULL)"
            );

            // Таблица статей
            LOGGER.info("DROP/CREATE table bg_articles");
            statement.execute("DROP TABLE IF EXISTS bg_articles;\n"
                    + "CREATE TABLE bg_articles (\n"
                    + "id bigserial primary key,\n"
                    + "title varchar (100) NOT NULL,\n"
                    + "content text,\n"
                    + "author_id varchar (50),\n"
                    + "likes int DEFAULT 0)"
            );

            // Таблица пользователей
            LOGGER.info("DROP/CREATE table bg_users");
            statement.execute("DROP TABLE IF EXISTS bg_users;\n"
                    + "CREATE TABLE bg_users (\n"
                    + "id bigserial primary key,\n"
                    + "login varchar (100) NOT NULL,\n"
                    + "name varchar (100),\n"
                    + "role_id int DEFAULT 1,\n"
                    + "rate int DEFAULT 0)"
            );

            // Таблица логов
            LOGGER.info("DROP/CREATE table bg_users");
            statement.execute("DROP TABLE IF EXISTS APP_LOGS;\n"
                    + "CREATE TABLE APP_LOGS (\n"
                    + "LOG_ID varchar(100) primary key,\n"
                    + "ENTRY_DATE timestamp,\n"
                    + "LOGGER varchar(100),\n"
                    + "LOG_LEVEL varchar(100),\n"
                    + "MESSAGE TEXT,\n"
                    + "EXCEPTION TEXT)"
            );

            // Таблица мобильных телефонов
            // TODO: Создать таблицу

        } catch (SQLException e) {
            LOGGER.error("sql exception", e);
        }
    }

    /**
     * Insert some lines into the tables
     */
    public static void insertSomeLines() {
        LOGGER.trace("start insertSomeLines");

        try (Connection connection = ConnectionFactory.getConnection(DatabaseType.BLOG);
             Statement statement = connection.createStatement();
        ) {
            // Таблица ролей
            statement.addBatch("insert into bg_roles (title)\n" +
                    "values ('Гость')");
            statement.addBatch("insert into bg_roles (title)\n" +
                    "values ('Модератор')");
            statement.addBatch("insert into bg_roles (title)\n" +
                    "values ('Автор')");
            statement.addBatch("insert into bg_roles (title)\n" +
                    "values ('Администратор')");

            // Таблица пользователей
            statement.addBatch("insert into bg_users (login, name, role_id)\n" +
                    "values ('ivanov', 'Иванов', '3')");
            statement.addBatch("insert into bg_users (login, name, role_id)\n" +
                    "values ('vetochkin', 'Веточкин', '1')");
            statement.addBatch("insert into bg_users (login, name, role_id)\n" +
                    "values ('kamushkin', 'Камушкин', '3')");
            statement.addBatch("insert into bg_users (login, name, role_id)\n" +
                    "values ('zaborchik', 'Заборчик', '3')");
            statement.addBatch("insert into bg_users (login, name, role_id)\n" +
                    "values ('zaplesneveiko', 'Заплесневейко', '3')");
            statement.addBatch("insert into bg_users (login, name, role_id)\n" +
                    "values ('root', 'Владелец', '4')");

            // Таблица статей
            statement.addBatch("insert into bg_articles (title, content, author_id)\n" +
                    "values ('Статья 1', 'Текст статьи', '1')");
            statement.addBatch("insert into bg_articles (title, content, author_id)\n" +
                    "values ('Статья 2', 'Текст статьи 2', '2')");
            statement.addBatch("insert into bg_articles (title, content, author_id)\n" +
                    "values ('Статья 3', 'Текст статьи 3', '3')");
            statement.addBatch("insert into bg_articles (title, content, author_id)\n" +
                    "values ('Статья 4', 'Текст статьи 4', '4')");
            statement.addBatch("insert into bg_articles (title, content, author_id)\n" +
                    "values ('Статья 5', 'Текст статьи 5', '5')");

            // Таблица мобильных телефонов
            // TODO: Накидать данных в таблицу

            statement.executeBatch();

        } catch (SQLException e) {
            LOGGER.error("sql exception", e);
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