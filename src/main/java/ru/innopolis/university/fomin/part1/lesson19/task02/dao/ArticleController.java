package ru.innopolis.university.fomin.part1.lesson19.task02.dao;

import ru.innopolis.university.fomin.part1.lesson19.task01.scheme.BlogDbScheme;
import ru.innopolis.university.fomin.part1.lesson19.task02.model.ArticleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ArticleController extends AbstractController<ArticleModel> {
    private static final String SELECT_ALL_SQL = "SELECT * FROM " + BlogDbScheme.ArticleTable.NAME;

    private static final String INSERT_SQL = "INSERT INTO " + BlogDbScheme.ArticleTable.NAME + " "
            + "(model, price, man) VALUES (?,?,?)";

    public ArticleController(Connection connection) {
        super(connection);
    }

    @Override
    public List<ArticleModel> getAll() {
        List<ArticleModel> result = new LinkedList<>();

        try (PreparedStatement ps = connection.prepareStatement(SELECT_ALL_SQL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ArticleModel articleModel = new ArticleModel();
                articleModel.setId(rs.getInt(1));
                articleModel.setTitle(rs.getString(2));
                articleModel.setContent(rs.getString(3));
                articleModel.setAuthor(rs.getString(4));
                articleModel.setLikes(rs.getInt(5));
                result.add(articleModel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public ArticleModel getEntityById(int id) {
        return null;
    }

    @Override
    public ArticleModel update(ArticleModel entity) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean create(ArticleModel entity) {
        return false;
    }
}
