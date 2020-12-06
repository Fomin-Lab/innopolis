package ru.innopolis.university.fomin.part1.lesson25.dao;

import ru.innopolis.university.fomin.part1.lesson25.connection.ConnectionManager;
import ru.innopolis.university.fomin.part1.lesson25.scheme.BlogDbScheme;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User controller for perform CRUD operations
 */
@EJB
public class UserController extends AbstractController<UserModel> {
    /**
     * SQL for inserting the entry
     */
    private static final String INSERT_SQL = "INSERT INTO " + BlogDbScheme.UsersTable.NAME + " "
            + "(login, name, role_id, rate) VALUES (?, ?, ?, ?)";

    /**
     * SQL for updating the entry
     */
    private static final String UPDATE_SQL = "UPDATE " + BlogDbScheme.UsersTable.NAME + " "
            + "SET login = ?, name = ?, role_id = ?, rate = ? "
            + "WHERE id = ?";

    /**
     * Constructor
     *
     * @param connection Jdbc connection
     */
    @Inject
    public UserController(ConnectionManager connection) {
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
        return BlogDbScheme.UsersTable.NAME;
    }

    /**
     * Create model from ResultSet
     *
     * @param rs ResultSet instance
     * @return Model
     * @throws SQLException If occur sql exception
     */
    @Override
    protected UserModel createModel(ResultSet rs) throws SQLException {
        return new UserModel(rs);
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
    protected void loadPreparedStatement(PreparedStatement ps, UserModel model, boolean updating) throws SQLException {
        model.sendToPreparedStatement(ps, updating);
    }
}
