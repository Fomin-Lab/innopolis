package ru.innopolis.university.fomin.part1.lesson23.dao;

import ru.innopolis.university.fomin.part1.lesson23.scheme.BlogDbScheme;
import ru.innopolis.university.fomin.part1.lesson23.model.ArticleModel;

import java.sql.*;

/**
 * Article controller for perform CRUD operations
 */
public class ArticleController extends AbstractController<ArticleModel> {
    /**
     * SQL for inserting the entry
     */
    private static final String INSERT_SQL = "INSERT INTO " + BlogDbScheme.ArticleTable.NAME + " "
            + "(title, content, author_id, likes) VALUES (?, ?, ?, ?)";

    /**
     * SQL for updating the entry
     */
    private static final String UPDATE_SQL = "UPDATE " + BlogDbScheme.ArticleTable.NAME + " "
            + "SET title = ?, content = ?, author_id = ?, likes = ? "
            + "WHERE id = ?";

    /**
     * Constructor
     *
     * @param connection Jdbc connection
     */
    public ArticleController(Connection connection) {
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
        return BlogDbScheme.ArticleTable.NAME;
    }

    /**
     * Create model from ResultSet
     *
     * @param rs ResultSet instance
     * @return Model
     * @throws SQLException If occur sql exception
     */
    @Override
    protected ArticleModel createModel(ResultSet rs) throws SQLException {
        return new ArticleModel(rs);
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
    protected void loadPreparedStatement(PreparedStatement ps, ArticleModel model, boolean updating) throws SQLException {
        model.sendToPreparedStatement(ps, updating);
    }
}
