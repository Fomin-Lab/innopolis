package ru.innopolis.university.fomin.part1.lesson25.controllers;

import ru.innopolis.university.fomin.part1.lesson25.connection.ConnectionManager;
import ru.innopolis.university.fomin.part1.lesson25.model.MobileModel;
import ru.innopolis.university.fomin.part1.lesson25.scheme.BlogDbScheme;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@EJB
public class MobileController extends AbstractController<MobileModel> {
    /**
     * SQL for inserting the entry
     */
    private static final String INSERT_SQL = "INSERT INTO " + BlogDbScheme.MobilesTable.NAME + " "
            + "(type_of_os, model) VALUES (?, ?)";

    /**
     * SQL for updating the entry
     */
    private static final String UPDATE_SQL = "UPDATE " + BlogDbScheme.MobilesTable.NAME + " "
            + "SET type_of_os = ?, model = ? "
            + "WHERE id = ?";

    /**
     * Constructor
     *
     * @param connection Instance of connection manager
     */
    @Inject
    public MobileController(ConnectionManager connection) {
        super(connection);
    }

    /**
     * SQL string
     *
     * @return SQL for inserting the entry
     */
    @Override
    protected String getInsertQuery() {
        return INSERT_SQL;
    }

    /**
     * SQL string
     *
     * @return SQL for updating the entry
     */
    @Override
    protected String getUpdateQuery() {
        return UPDATE_SQL;
    }

    /**
     * @return Name of table
     */
    @Override
    protected String tableName() {
        return BlogDbScheme.MobilesTable.NAME;
    }

    /**
     * Create model from ResultSet
     *
     * @param rs ResultSet instance
     * @return Model
     * @throws SQLException If occur sql exception
     */
    @Override
    protected MobileModel createModel(ResultSet rs) throws SQLException {
        return new MobileModel(rs);
    }

    /**
     * Loading PreparedStatement from model
     *
     * @param ps       PreparedStatement instance
     * @param model    Model for load
     * @param updating True if loading UPDATE query, false INSERT query.
     *                 For UPDATE query need fill id param
     * @throws SQLException If occur sql exception
     */
    @Override
    protected void loadPreparedStatement(PreparedStatement ps, MobileModel model, boolean updating) throws SQLException {
        model.sendToPreparedStatement(ps, updating);
    }
}
