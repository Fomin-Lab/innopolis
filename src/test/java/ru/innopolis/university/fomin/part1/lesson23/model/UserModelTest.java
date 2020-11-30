package ru.innopolis.university.fomin.part1.lesson23.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class UserModelTest {
    /**
     * Model instance
     */
    protected UserModel model;

    /**
     * stub
     */
    @Mock
    protected ResultSet resultSet;

    /**
     * Execute before each the test
     */
    @BeforeEach
    void setUp() {
        openMocks(this);
        model = new UserModel("Adam", "adam", 4, 32);
    }

    /**
     * Test on success for getter/setter id field
     *
     * @param id Test numbers
     */
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 99999, -34})
    void getSetId(int id) {
        model.setId(id);
        assertEquals(id, model.getId());
    }

    /**
     * Test on success for getter/setter login field
     *
     * @param login Test words
     */
    @ParameterizedTest
    @ValueSource(strings = {"vasiaas132", "dima43", "katya223"})
    void getSetLogin(String login) {
        model.setLogin(login);
        assertEquals(login, model.getLogin());
    }

    /**
     * Test on success for getter/setter name field
     *
     * @param name Test words
     */
    @ParameterizedTest
    @ValueSource(strings = {"Vasia", "Dima", "Katya"})
    void getSetTitle(String name) {
        model.setName(name);
        assertEquals(name, model.getName());
    }

    /**
     * Test on success for getter/setter roleId field
     *
     * @param roleId Test numbers
     */
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 99999, -34})
    void getSetRoleId(int roleId) {
        model.setRoleId(roleId);
        assertEquals(roleId, model.getRoleId());
    }

    /**
     * Test on success for getter/setter rate field
     *
     * @param rate Test numbers
     */
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 99999, -34})
    void getSetRate(int rate) {
        model.setRoleId(rate);
        assertEquals(rate, model.getRoleId());
    }

    /**
     * Test on success for loadFromResultSet method in UserModel class
     *
     * @throws SQLException If occur sql error
     */
    @Test
    void loadFromResultSet() throws SQLException {
        int id = 3;
        String name = "Tomas";
        String login = "tomas";
        int roleId = 2;
        int rate = 142;

        when(resultSet.getInt(1)).thenReturn(id);
        when(resultSet.getString(2)).thenReturn(login);
        when(resultSet.getString(3)).thenReturn(name);
        when(resultSet.getInt(4)).thenReturn(roleId);
        when(resultSet.getInt(5)).thenReturn(rate);

        model.loadFromResultSet(resultSet);

        assertEquals(id, model.getId());
        assertEquals(name, model.getName());
        assertEquals(login, model.getLogin());
        assertEquals(roleId, model.getRoleId());
        assertEquals(rate, model.getRate());
    }
}