package ru.innopolis.university.fomin.part1.lesson25.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import java.sql.Connection;
import java.sql.SQLException;

@EJB
public class PostgreConnectionManager implements ConnectionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostgreConnectionManager.class);

    @Override
    public Connection getConnection() {
        LOGGER.trace("start connection to postgresql");
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = ConnectionFactory.getConnection(DatabaseType.BLOG);
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.error("exception in PostgreConnectionManager", e);
        }
        return connection;
    }
}
