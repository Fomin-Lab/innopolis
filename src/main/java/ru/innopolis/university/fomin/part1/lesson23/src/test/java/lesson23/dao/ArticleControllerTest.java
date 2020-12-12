package lesson23.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import lesson23.model.ArticleModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Tests for ArticleController class
 */
class ArticleControllerTest {
    /**
     * Controller instance
     */
    protected ArticleController controller;

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
        controller = new ArticleController(connection);
    }

    /**
     * Test on not null return for getInsertQuery method in ArticleController class
     */
    @Test
    void getInsertQuery() {
        assertNotNull(controller.getInsertQuery());
    }

    /**
     * Test on not null return for getUpdateQuery method in ArticleController class
     */
    @Test
    void getUpdateQuery() {
        assertNotNull(controller.getUpdateQuery());
    }

    /**
     * Test on not null return for tableName method in ArticleController class
     */
    @Test
    void tableName() {
        assertNotNull(controller.tableName());
    }

    /**
     * Test on not null return for createModel method in ArticleController class
     */
    @Test
    void createModel() throws SQLException {
        assertNotNull(controller.createModel(resultSet));
    }

    /**
     * Test on success for loadPreparedStatement method in ArticleController class
     */
    @Test
    void loadPreparedStatement() {
        assertDoesNotThrow(() -> controller.loadPreparedStatement(mock(PreparedStatement.class), mock(ArticleModel.class), true));
    }
}