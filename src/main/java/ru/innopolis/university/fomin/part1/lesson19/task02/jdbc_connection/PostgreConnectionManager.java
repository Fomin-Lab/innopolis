package ru.innopolis.university.fomin.part1.lesson19.task02.jdbc_connection;

import ru.innopolis.university.fomin.part1.lesson19.task01.connection.ConnectionFactory;
import ru.innopolis.university.fomin.part1.lesson19.task01.connection.DatabaseType;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgreConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection(DatabaseType.BLOG);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
