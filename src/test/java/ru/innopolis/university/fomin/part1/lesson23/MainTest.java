package ru.innopolis.university.fomin.part1.lesson23;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.university.fomin.part1.lesson23.connection.ConnectionManager;
import ru.innopolis.university.fomin.part1.lesson23.dao.ArticleController;
import ru.innopolis.university.fomin.part1.lesson23.dao.RoleController;
import ru.innopolis.university.fomin.part1.lesson23.dao.UserController;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Tests for Main class
 */
class MainTest {
    /**
     * slf4j wrapper
     */
    private static final Logger LOGGER = LoggerFactory.getLogger("testing");

    /**
     * stub
     */
    @Mock
    protected Connection connection;

    /**
     * stub
     */
    @Mock
    protected ConnectionManager connectionManager;

    /**
     * stub
     * use for all query and create @resultSet
     */
    @Mock
    protected PreparedStatement preparedStatement;

    /**
     * stub
     * use sql select all and create @resultSetWithFalse
     */
    @Mock
    protected PreparedStatement preparedStatementForSelectAll;

    /**
     * stub
     * method next return true
     */
    @Mock
    protected ResultSet resultSet;

    /**
     * stub
     * method next return false
     */
    @Mock
    protected ResultSet resultSetWithFalse;

    /**
     * Execute before each test
     */
    @BeforeEach
    void setUp() throws SQLException {
        LOGGER.trace("setUp");
        openMocks(this);
        when(connectionManager.getConnection()).thenReturn(connection);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(preparedStatementForSelectAll.executeQuery()).thenReturn(resultSetWithFalse);
        when(resultSet.next()).thenReturn(true);
    }

    /**
     * Execute after each test
     */
    @AfterEach
    void tearDown() {
        LOGGER.trace("tearDown");
    }

    /**
     * Execute before all tests
     */
    @BeforeAll
    static void setUpAll() {
        LOGGER.trace("setUpAll");
    }

    /**
     * Execute after all tests
     */
    @AfterAll
    static void tearDownAll() {
        LOGGER.trace("tearDownAll");
    }

    /**
     * Test on success for method demoCRUD in Main class
     *
     * @throws SQLException If occur sql error
     */
    @Test
    @DisplayName("Тестируем метод demoCRUD в классе Main")
    void demoCRUDWithOk() throws SQLException {
        RoleController roleController = new RoleController(connection);
        UserController userController = new UserController(connection);
        ArticleController articleController = new ArticleController(connection);

        // заглушки для roleController
        when(connection.prepareStatement(roleController.getInsertQuery(), Statement.RETURN_GENERATED_KEYS)).thenReturn(preparedStatement);
        when(connection.prepareStatement(roleController.getSelectByIdQuery())).thenReturn(preparedStatement);
        when(connection.prepareStatement(roleController.getUpdateQuery())).thenReturn(preparedStatement);

        // заглушки для userController
        when(connection.prepareStatement(userController.getDeleteByIdQuery())).thenReturn(preparedStatement);
        when(connection.prepareStatement(userController.getSelectAllQuery())).thenReturn(preparedStatement);

        // заглушки для getAll
        when(connection.prepareStatement(articleController.getSelectAllQuery())).thenReturn(preparedStatementForSelectAll);
        when(connection.prepareStatement(roleController.getSelectAllQuery())).thenReturn(preparedStatementForSelectAll);
        when(connection.prepareStatement(userController.getSelectAllQuery())).thenReturn(preparedStatementForSelectAll);

        assertDoesNotThrow(() -> Main.demoCRUD(connection));
    }

    /**
     * Test for method demoDemo in Main class
     * Check on NullPointerException
     */
    @Test
    @DisplayName("Тестируем метод demoCRUD на NullPointerException в классе Main")
    void demoCRUDWithNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> Main.demoCRUD(null));
        assertNull(exception.getMessage());
    }

    /**
     * Test on success for method demoSavepoint in Main class
     *
     * @throws SQLException If occur sql error
     */
    @Test
    void demoSavepoint() throws SQLException {
        UserController userController = new UserController(connection);
        when(connection.prepareStatement(userController.getInsertQuery(), Statement.RETURN_GENERATED_KEYS)).thenReturn(preparedStatement);

        assertDoesNotThrow(() -> Main.demoSavepoint(connection));
    }

    /**
     * Test on success for method demoBatch in Main class
     *
     * @throws SQLException If occur sql error
     */
    @Test
    void demoBatch() throws SQLException {
        UserController userController = new UserController(connection);
        when(connection.prepareStatement(userController.getInsertQuery())).thenReturn(preparedStatement);
        when(connection.prepareStatement(userController.getUpdateQuery())).thenReturn(preparedStatement);

        assertDoesNotThrow(() -> Main.demoBatch(connection));
    }
}