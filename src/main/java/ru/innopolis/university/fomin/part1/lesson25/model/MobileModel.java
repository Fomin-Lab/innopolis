package ru.innopolis.university.fomin.part1.lesson25.model;

import ru.innopolis.university.fomin.part1.lesson25.statistic.Visitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileModel extends AbstractModel {
    protected int id;
    protected String typeOS;
    protected String model;

    /**
     * Default constructor
     */
    public MobileModel() {
    }

    /**
     * Constructor
     */
    public MobileModel(String typeOS, String model) {
        this.typeOS = typeOS;
        this.model = model;
    }

    /**
     * Constructor for loading model from ResultSet
     *
     * @param rs ResultSet instance
     * @throws SQLException If occur sql exception
     */
    public MobileModel(ResultSet rs) throws SQLException {
        loadFromResultSet(rs);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTypeOS(String type) {
        this.typeOS = type;
    }

    public String getTypeOS() {
        return this.typeOS;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "MobileModel{" +
                "id=" + id +
                ", typeOS='" + typeOS + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public void loadFromResultSet(ResultSet rs) throws SQLException {
        setId(rs.getInt(1));
        setTypeOS(rs.getString(2));
        setModel(rs.getString(3));
    }

    @Override
    public void sendToPreparedStatement(PreparedStatement ps, boolean updating) throws SQLException {
        ps.setString(1, getTypeOS());
        ps.setString(2, getModel());

        if (updating) {
            ps.setInt(3, getId());
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitMobile(this);
    }
}
