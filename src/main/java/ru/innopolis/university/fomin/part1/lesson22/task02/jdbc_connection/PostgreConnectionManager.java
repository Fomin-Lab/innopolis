package ru.innopolis.university.fomin.part1.lesson22.task02.jdbc_connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.university.fomin.part1.lesson22.task01.connection.ConnectionFactory;
import ru.innopolis.university.fomin.part1.lesson22.task01.connection.DatabaseType;

import java.sql.Connection;
import java.sql.SQLException;

public class PostgreConnectionManager implements ConnectionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostgreConnectionManager.class);

    @Override
    public Connection getConnection() {
        LOGGER.trace("start connection to postgresql");
        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection(DatabaseType.BLOG);
        } catch (SQLException e) {
            LOGGER.error("sql exception", e);
        }
        return connection;
    }
}
