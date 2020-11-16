package ru.innopolis.university.fomin.examples.jdbc.readExample.dao;

import ru.innopolis.university.fomin.examples.jdbc.DBUtil;
import ru.innopolis.university.fomin.examples.jdbc.readExample.ConnectionManager.ConnectionManager;
import ru.innopolis.university.fomin.examples.jdbc.readExample.ConnectionManager.ConnectionManagerJdbcImpl;
import ru.innopolis.university.fomin.examples.jdbc.readExample.pojo.Mobile;

import java.sql.*;

public class MobileDaoJdbcImpl implements MobileDao {
    private static final ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    public MobileDaoJdbcImpl() throws SQLException {
        DBUtil.renewDatabase();
    }

    @Override
    public Long addMobile(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO mobile values (DEFAULT, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            )
        ) {
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setInt(2, mobile.getPrice());
            preparedStatement.setString(3, mobile.getManufacturer());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Mobile getMobileById(Long id) {
        try (Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM mobile WHERE id = ?"
            );
        ) {
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Mobile(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(4)
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateMobileById(Mobile mobile) {
        try (Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE mobile SET model = ?, price = ?, manufacturer = ?" +
                        "WHERE id = ?"
            );
        ) {
            preparedStatement.setString(1, mobile.getModel());
            preparedStatement.setInt(2, mobile.getPrice());
            preparedStatement.setString(3, mobile.getManufacturer());
            preparedStatement.setInt(4, mobile.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteMobileById(Long id) {
        try (Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM mobile WHERE id = ?"
            );
        ) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
