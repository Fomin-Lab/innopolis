package lesson23.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import lesson23.model.RoleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Tests for RoleController class
 */
class RoleControllerTest {
    /**
     * Controller instance
     */
    protected RoleController controller;

    /**
     * stub
     */
    @Mock
    protected Connection connection;

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
        controller = new RoleController(connection);
    }

    /**
     * Test on not null return for getInsertQuery method in RoleController class
     */
    @Test
    void getInsertQuery() {
        assertNotNull(controller.getInsertQuery());
    }

    /**
     * Test on not null return for getUpdateQuery method in RoleController class
     */
    @Test
    void getUpdateQuery() {
        assertNotNull(controller.getUpdateQuery());
    }

    /**
     * Test on not null return for tableName method in RoleController class
     */
    @Test
    void tableName() {
        assertNotNull(controller.tableName());
    }

    /**
     * Test on not null return for createModel method in RoleController class
     */
    @Test
    void createModel() throws SQLException {
        assertNotNull(controller.createModel(resultSet));
    }

    /**
     * Test on success for loadPreparedStatement method in RoleController class
     */
    @Test
    void loadPreparedStatement() {
        assertDoesNotThrow(() -> controller.loadPreparedStatement(mock(PreparedStatement.class), mock(RoleModel.class), true));
    }
}