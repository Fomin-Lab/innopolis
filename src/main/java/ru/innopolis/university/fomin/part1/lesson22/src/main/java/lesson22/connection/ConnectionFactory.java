package lesson22.connection;

import lesson22.DatabaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection factory implements abstract method pattern
 */
public class ConnectionFactory {
    /**
     * Get connection by type
     *
     * @param type Type of database for create connection
     * @return Connection instance
     * @throws SQLException If occur sql exception
     */
    public static Connection getConnection(DatabaseType type) throws SQLException {
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
