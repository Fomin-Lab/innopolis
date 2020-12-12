package lesson22.model;

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

    /**
     * Constructor
     *
     * @param title Article title
     * @param content Article content
     * @param authorId Article author_id
     * @param likes Number of likes put to the article
     */
    public ArticleModel(String title, String content, int authorId, int likes) {
        this.title = title;
        this.content = content;
        this.authorId = authorId;
        this.likes = likes;
    }

    /**
     * Constructor for loading model from ResultSet
     *
     * @param rs ResultSet instance
     * @throws SQLException If occur sql exception
     */
    public ArticleModel(ResultSet rs) throws SQLException {
        loadFromResultSet(rs);
    }

    // getters and setters
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
     * Loading model from result set
     *
     * @param rs ResultSet
     * @throws SQLException If occur sql exception
     */
    @Override
    public void loadFromResultSet(ResultSet rs) throws SQLException {
        setId(rs.getInt(1));
        setTitle(rs.getString(2));
        setContent(rs.getString(3));
        setAuthorId(rs.getInt(4));
        setLikes(rs.getInt(5));
    }

    /**
     * Loading model into prepared statement
     *
     * @param ps PreparedStatement instance
     * @param updating True if loading UPDATE query, false INSERT query.
     *                 For UPDATE query need fill id param
     * @throws SQLException If occur sql exception
     */
    @Override
    public void sendToPreparedStatement(PreparedStatement ps, boolean updating) throws SQLException {
        ps.setString(1, getTitle());
        ps.setString(2, getContent());
        ps.setInt(3, getAuthorId());
        ps.setInt(4, getLikes());

        if (updating) {
            ps.setInt(5, getId());
        }
    }
}
