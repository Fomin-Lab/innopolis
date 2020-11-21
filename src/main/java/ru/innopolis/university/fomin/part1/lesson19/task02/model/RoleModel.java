package ru.innopolis.university.fomin.part1.lesson19.task02.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Model for the roles table
 */
public class RoleModel extends AbstractModel {
    private int id;
    private String title;

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
     * @param rs ResultSet
     * @return New model instance
     * @throws SQLException If occur sql exception
     */
    public static RoleModel createFromResultSet(ResultSet rs) throws SQLException {
        RoleModel model = new RoleModel();
        model.setId(rs.getInt(1));
        model.setTitle(rs.getString(2));
        return model;
    }
}
