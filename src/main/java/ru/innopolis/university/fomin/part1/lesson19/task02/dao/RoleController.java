package ru.innopolis.university.fomin.part1.lesson19.task02.dao;

import ru.innopolis.university.fomin.part1.lesson19.task01.scheme.BlogDbScheme;
import ru.innopolis.university.fomin.part1.lesson19.task02.model.ArticleModel;
import ru.innopolis.university.fomin.part1.lesson19.task02.model.RoleModel;

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
     * @param connection Jdbc connection
     */
    public RoleController(Connection connection) {
        super(connection);
    }

    /**
     * @return SQL for inserting the entry
     */
    @Override
    protected String getInsertQuery() {
        return INSERT_SQL;
    }

    /**
     * @return SQL for updating the entry
     */
    @Override
    protected String getUpdateQuery() {
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
     * @param rs ResultSet instance
     * @return Model
     * @throws SQLException If occur sql exception
     */
    @Override
    protected RoleModel createModel(ResultSet rs) throws SQLException {
        return RoleModel.createFromResultSet(rs);
    }

    /**
     * @param ps       PreparedStatement instance
     * @param model    Model for load
     * @param updating True if loading UPDATE query, false INSERT query.
     *                 For UPDATE query need fill id param
     * @throws SQLException If occur sql exception
     */
    @Override
    protected void loadToPreparedStatement(PreparedStatement ps, RoleModel model, boolean updating) throws SQLException {
        ps.setString(1, model.getTitle());

        if (updating) {
            ps.setInt(2, model.getId());
        }
    }
}
