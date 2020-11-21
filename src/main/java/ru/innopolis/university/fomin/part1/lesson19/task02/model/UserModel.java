package ru.innopolis.university.fomin.part1.lesson19.task02.model;

import ru.innopolis.university.fomin.examples.gof.creational.builder.example1.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Model for the users table
 */
public class UserModel extends AbstractModel {
    private int id;
    private String name;
    private String login;
    private int roleId;
    private int rate;

    public UserModel() { }

    public UserModel(String name, String login, int roleId, int rate) {
        this.name = name;
        this.login = login;
        this.roleId = roleId;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", roleId=" + roleId +
                ", rate=" + rate +
                '}';
    }

    /**
     * @param rs ResultSet
     * @return New model instance
     * @throws SQLException If occur sql exception
     */
    public static UserModel createFromResultSet(ResultSet rs) throws SQLException {
        UserModel model = new UserModel();
        model.setId(rs.getInt(1));
        model.setLogin(rs.getString(2));
        model.setName(rs.getString(3));
        model.setRoleId(rs.getInt(4));
        model.setRate(rs.getInt(5));
        return model;
    }
}
