package ru.innopolis.university.fomin.part1.lesson25.model;

import ru.innopolis.university.fomin.part1.lesson25.statistic.Visitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Реализовать
public class MobileModel extends AbstractModel {
    protected String typeOS;

    public void setTypeOS(String type) {
        this.typeOS = type;
    }

    public String getTypeOS() {
        return this.typeOS;
    }

    @Override
    public void loadFromResultSet(ResultSet rs) throws SQLException {

    }

    @Override
    public void sendToPreparedStatement(PreparedStatement ps, boolean updating) throws SQLException {

    }

    @Override
    public void accept(Visitor v) {
        v.visitMobile(this);
    }
}
