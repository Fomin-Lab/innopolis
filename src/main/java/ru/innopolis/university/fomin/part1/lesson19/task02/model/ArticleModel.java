package ru.innopolis.university.fomin.part1.lesson19.task02.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Model for the articles table
 */
public class ArticleModel extends AbstractModel {
    private int id;
    private String title;
    private String content;
    private int authorId;
    private int likes;

    public ArticleModel() { }

    public ArticleModel(String title, String content, int authorId, int likes) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "ArticleModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authorId='" + authorId + '\'' +
                ", likes=" + likes +
                '}';
    }

    /**
     * @param rs ResultSet
     * @return New model instance
     * @throws SQLException If occur sql exception
     */
    public static ArticleModel createFromResultSet(ResultSet rs) throws SQLException {
        ArticleModel model = new ArticleModel();
        model.setId(rs.getInt(1));
        model.setTitle(rs.getString(2));
        model.setContent(rs.getString(3));
        model.setAuthorId(rs.getInt(4));
        model.setLikes(rs.getInt(5));
        return model;
    }
}
