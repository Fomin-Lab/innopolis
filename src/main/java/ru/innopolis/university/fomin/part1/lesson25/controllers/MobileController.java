package ru.innopolis.university.fomin.part1.lesson25.controllers;

import ru.innopolis.university.fomin.part1.lesson25.connection.ConnectionManager;
import ru.innopolis.university.fomin.part1.lesson25.model.MobileModel;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// TODO: Реализовать
@EJB
public class MobileController extends AbstractController<MobileModel> {
    /**
     * Constructor
     *
     * @param connection Instance of connection manager
     */
    @Inject
    public MobileController(ConnectionManager connection) {
        super(connection);
    }

    @Override
    protected String getInsertQuery() {
        return null;
    }

    @Override
    protected String getUpdateQuery() {
        return null;
    }

    @Override
    protected String tableName() {
        return null;
    }

    @Override
    protected MobileModel createModel(ResultSet rs) throws SQLException {
        return null;
    }

    @Override
    protected void loadPreparedStatement(PreparedStatement ps, MobileModel model, boolean updating) throws SQLException {

    }
}
