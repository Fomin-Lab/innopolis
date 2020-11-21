package ru.innopolis.university.fomin.part1.lesson19.task02.dao;

import ru.innopolis.university.fomin.part1.lesson19.task01.scheme.BlogDbScheme;
import ru.innopolis.university.fomin.part1.lesson19.task02.model.ArticleModel;

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
     * @param connection Jdbc connection
     */
    public ArticleController(Connection connection) {
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
        return BlogDbScheme.ArticleTable.NAME;
    }

    /**
     * @param rs ResultSet instance
     * @return Model
     * @throws SQLException If occur sql exception
     */
    @Override
    protected ArticleModel createModel(ResultSet rs) throws SQLException {
        return ArticleModel.createFromResultSet(rs);
    }

    /**
     * @param ps       PreparedStatement instance
     * @param model    Model for load
     * @param updating True if loading UPDATE query, false INSERT query.
     *                 For UPDATE query need fill id param
     * @throws SQLException If occur sql exception
     */
    @Override
    protected void loadToPreparedStatement(PreparedStatement ps, ArticleModel model, boolean updating) throws SQLException {
        ps.setString(1, model.getTitle());
        ps.setString(2, model.getContent());
        ps.setInt(3, model.getAuthorId());
        ps.setInt(4, model.getLikes());

        if (updating) {
            ps.setInt(5, model.getId());
        }
    }
}
