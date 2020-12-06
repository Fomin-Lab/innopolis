package ru.innopolis.university.fomin.part1.lesson25.dao;

import ru.innopolis.university.fomin.part1.lesson25.connection.ConnectionManager;
import ru.innopolis.university.fomin.part1.lesson25.scheme.BlogDbScheme;
import ru.innopolis.university.fomin.part1.lesson25.model.RoleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Role controller for perform CRUD operations
 */
public class RoleController extends AbstractController<RoleModel> {
    /**
     * SQL for inserting the entry
     */
    private static final String INSERT_SQL = "INSERT INTO " + BlogDbScheme.RolesTable.NAME + " "
            + "(title) VALUES (?)";

    /**
     * SQL for updating the entry
     */
    private static final String UPDATE_SQL = "UPDATE " + BlogDbScheme.RolesTable.NAME + " "
            + "SET title = ? "
            + "WHERE id = ?";

    /**
     * Constructor
     *
     * @param connection Jdbc connection
     */
    public RoleController(ConnectionManager connection) {
        super(connection);
    }

    /**
     * SQL string
     *
     * @return SQL for inserting the entry
     */
    @Override
    public String getInsertQuery() {
        return INSERT_SQL;
    }

    /**
     * SQL string
     *
     * @return SQL for updating the entry
     */
    @Override
    public String getUpdateQuery() {
        return UPDATE_SQL;
    }

    /**
     * @return Name of table
     */
    @Override
    protected String tableName() {
        return BlogDbScheme.RolesTable.NAME;
    }

    /**
     * Create model from ResultSet
     *
     * @param rs ResultSet instance
     * @return Model
     * @throws SQLException If occur sql exception
     */
    @Override
    protected RoleModel createModel(ResultSet rs) throws SQLException {
        return new RoleModel(rs);
    }

    /**
     * Loading PreparedStatement from model
     *
     * @param ps       PreparedStatement instance
     * @param model    Model for load
     * @param updating True if loading UPDATE query, false INSERT query.
     *                 For UPDATE query need fill id param
     * @throws SQLException If occur sql exception
     */
    @Override
    protected void loadPreparedStatement(PreparedStatement ps, RoleModel model, boolean updating) throws SQLException {
        model.sendToPreparedStatement(ps, updating);
    }
}
