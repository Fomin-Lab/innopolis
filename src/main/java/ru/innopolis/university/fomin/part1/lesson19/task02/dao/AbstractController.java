package ru.innopolis.university.fomin.part1.lesson19.task02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public abstract class AbstractController<T> {
    protected Connection connection;

    public AbstractController(Connection connection) {
        this.connection = connection;
    }

    public abstract List<T> getAll();
    public abstract T getEntityById(int id);
    public abstract T update(T entity);
    public abstract boolean delete(int id);
    public abstract boolean create(T entity);
}
