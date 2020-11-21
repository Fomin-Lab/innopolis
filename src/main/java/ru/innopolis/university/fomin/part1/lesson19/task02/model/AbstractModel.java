package ru.innopolis.university.fomin.part1.lesson19.task02.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Abstract model for entry in table
 */
public abstract class AbstractModel {
    /**
     * Loading model from result set
     *
     * @param rs ResultSet
     * @throws SQLException If occur sql exception
     */
    public abstract void loadFromResultSet(ResultSet rs) throws SQLException;

    /**
     * Loading model into prepared statement
     *
     * @param ps PreparedStatement instance
     * @param updating True if loading UPDATE query, false INSERT query.
     *                 For UPDATE query need fill id param
     * @throws SQLException If occur sql exception
     */
    public abstract void sendToPreparedStatement(PreparedStatement ps, boolean updating) throws SQLException;
}
