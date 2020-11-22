package ru.innopolis.university.fomin.part1.lesson19.task02.dao;

import ru.innopolis.university.fomin.part1.lesson19.task02.model.AbstractModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract controller for perform CRUD operations
 * @param <T> Type of model
 */
public abstract class AbstractController<T extends AbstractModel> {
    /**
     * Jdbc connection
     */
    protected Connection connection;

    /**
     * Constructor
     * @param connection Instance of jdbc connection
     */
    public AbstractController(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return SQL for searching the all entries
     */
    protected String getSelectAllQuery() {
        return "SELECT * FROM " + tableName();
    }

    /**
     * @return SQL for searching the entry by id
     */
    public String getSelectByIdQuery() {
        return "SELECT * FROM " + tableName() + " "
                + "WHERE id = ?";
    }

    /**
     * @return SQL for deleting the entry by id
     */
    public String getDeleteByIdQuery() {
        return "DELETE FROM " + tableName() + " "
                + "WHERE id = ?";
    }

    /**
     * @return SQL for inserting the entry
     */
    protected abstract String getInsertQuery();

    /**
     * @return SQL for updating the entry
     */
    protected abstract String getUpdateQuery();

    /**
     * @return Name of table in child class
     */
    protected abstract String tableName();

    /**
     * Create model from ResultSet
     *
     * @param rs ResultSet instance
     * @return Instance of model
     * @throws SQLException If occur sql exception
     */
    protected abstract T createModel(ResultSet rs) throws SQLException;

    /**
     * Loading prepared statement by model
     *
     * @param ps PreparedStatement instance
     * @param model Model for load
     * @param updating
     *          True if loading UPDATE query, false INSERT query.
     *          For UPDATE query need fill id param
     * @throws SQLException If occur sql exception
     */
    protected abstract void loadPreparedStatement(PreparedStatement ps, T model, boolean updating) throws SQLException;

    /**
     * Select all entries
     *
     * @return List of entries from table
     */
    public List<T> getAll() {
        List<T> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(getSelectAllQuery())) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(createModel(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Select entry by id
     *
     * @param id Identifier the entry in table
     * @return Instance of model
     */
    public T getEntityById(int id) {
        try (PreparedStatement ps = connection.prepareStatement(getSelectByIdQuery())) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return createModel(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Delete entity by id
     *
     * @param id Identifier the entry in table
     * @return True if was deleted
     */
    public boolean delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(getDeleteByIdQuery())) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Create entity from model
     *
     * @param model Create new entry in table by model
     * @return Identifier of created entry
     */
    public int create(T model) {
        try (PreparedStatement ps = connection.prepareStatement(getInsertQuery(), Statement.RETURN_GENERATED_KEYS)) {
            loadPreparedStatement(ps, model, false);
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    /**
     * Update entry by model
     *
     * @param model Update entry in table by model
     * @return True if success updated
     */
    public boolean update(T model) {
        try (PreparedStatement ps = connection.prepareStatement(getUpdateQuery())) {
            loadPreparedStatement(ps, model, true);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
