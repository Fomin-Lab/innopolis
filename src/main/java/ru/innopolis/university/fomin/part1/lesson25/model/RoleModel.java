package ru.innopolis.university.fomin.part1.lesson25.model;

import ru.innopolis.university.fomin.part1.lesson25.statistic.Visitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Model for the roles table
 */
public class RoleModel extends AbstractModel {
    private int id;
    private String title;

    /**
     * Constructor
     *
     * @param title Title of role
     */
    public RoleModel(String title) {
        this.title = title;
    }

    /**
     * Constructor for loading model from ResultSet
     *
     * @param rs ResultSet instance
     * @throws SQLException If occur sql exception
     */
    public RoleModel(ResultSet rs) throws SQLException {
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

    @Override
    public String toString() {
        return "RoleModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    /**
     * Loading model from result set
     *
     * @param rs ResultSet
     * @throws SQLException If occur sql exception
     */
    public void loadFromResultSet(ResultSet rs) throws SQLException {
        setId(rs.getInt(1));
        setTitle(rs.getString(2));
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

        if (updating) {
            ps.setInt(2, getId());
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitRole(this);
    }
}
