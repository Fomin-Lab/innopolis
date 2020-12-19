package ru.innopolis.university.fomin.part1.lesson25.model;

import ru.innopolis.university.fomin.part1.lesson25.statistic.Visitor;

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
    private String password;
    private int roleId;
    private int rate;

    /**
     * Default constructor
     */
    public UserModel() { }

    /**
     * @param name User name
     * @param login User login
     * @param roleId User role_id
     * @param rate User rate
     */
    public UserModel(String name, String login, int roleId, int rate) {
        this.name = name;
        this.login = login;
        this.roleId = roleId;
        this.rate = rate;
    }

    /**
     * Constructor for loading model from ResultSet
     *
     * @param rs ResultSet instance
     * @throws SQLException If occur sql exception
     */
    public UserModel(ResultSet rs) throws SQLException {
        loadFromResultSet(rs);
    }

    // getters and setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", rate=" + rate +
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
        setLogin(rs.getString(2));
        setPassword(rs.getString(3));
        setName(rs.getString(4));
        setRoleId(rs.getInt(5));
        setRate(rs.getInt(6));
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
        ps.setString(1, getLogin());
        ps.setString(2, getPassword());
        ps.setString(3, getName());
        ps.setInt(4, getRoleId());
        ps.setInt(5, getRate());

        if (updating) {
            ps.setInt(6, getId());
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitUser(this);
    }
}
