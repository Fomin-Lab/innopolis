package ru.innopolis.university.fomin.part1.lesson23.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.university.fomin.part1.lesson23.DatabaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection factory implements abstract method pattern
 */
public class ConnectionFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostgreConnectionManager.class);

    /**
     * Get connection by type
     *
     * @param type Type of database for create connection
     * @return Connection instance
     * @throws SQLException If occur sql exception
     */
    public static Connection getConnection(DatabaseType type) throws SQLException {
        LOGGER.trace("create connection by connection factory");
        switch (type) {
            case BLOG:
                return DriverManager.getConnection(
                        DatabaseUtil.getConnectionString(DatabaseUtil.DB_NAME),
                        DatabaseUtil.USERNAME,
                        DatabaseUtil.PASSWORD
                );
            case DEFAULT:
            default:
                return DriverManager.getConnection(
                        DatabaseUtil.getConnectionString(null),
                        DatabaseUtil.USERNAME,
                        DatabaseUtil.PASSWORD
                );
        }
    }
}
