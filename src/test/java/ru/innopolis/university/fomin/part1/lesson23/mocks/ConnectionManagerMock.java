package ru.innopolis.university.fomin.part1.lesson23.mocks;

import ru.innopolis.university.fomin.part1.lesson23.connection.ConnectionManager;

import java.sql.Connection;

public class ConnectionManagerMock implements ConnectionManager {
    @Override
    public Connection getConnection() {
        return new ConnectionMock();
    }
}
