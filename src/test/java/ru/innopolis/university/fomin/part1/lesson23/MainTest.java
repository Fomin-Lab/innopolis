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
import static org.mockito.MockitoAnnotations.initMocks;

class MainTest {
    private static final Logger LOGGER = LoggerFactory.getLogger("testing");
    @Mock
    protected Connection connection;
    @Mock
    protected ConnectionManager connectionManager;
    @Mock
    protected PreparedStatement preparedStatement;
    @Mock
    protected PreparedStatement preparedStatementForSelectAll;
    @Mock
    protected ResultSet resultSet;
    @Mock
    protected ResultSet resultSetWithFalse;

    @BeforeEach
    void setUp() throws SQLException {
        LOGGER.trace("setUp");
        initMocks(this);
        when(connectionManager.getConnection()).thenReturn(connection);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSet);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(preparedStatementForSelectAll.executeQuery()).thenReturn(resultSetWithFalse);
        when(resultSet.next()).thenReturn(true);
    }

    @AfterEach
    void tearDown() {
        LOGGER.trace("tearDown");
    }

    @BeforeAll
    static void setUpAll() {
        LOGGER.trace("setUpAll");
    }

    @AfterAll
    static void tearDownAll() {
        LOGGER.trace("tearDownAll");
    }

    @Test
    @DisplayName("Тестируем метод demoCRUD в классе Main")
    void demoCRUDWithOk() throws SQLException {
        RoleController roleController = new RoleController(connection);
        UserController userController = new UserController(connection);
        ArticleController articleController = new ArticleController(connection);

        when(connection.prepareStatement(roleController.getInsertQuery(), Statement.RETURN_GENERATED_KEYS)).thenReturn(preparedStatement);
        when(connection.prepareStatement(roleController.getSelectByIdQuery())).thenReturn(preparedStatement);
        when(connection.prepareStatement(roleController.getUpdateQuery())).thenReturn(preparedStatement);

        when(connection.prepareStatement(userController.getDeleteByIdQuery())).thenReturn(preparedStatement);
        when(connection.prepareStatement(userController.getSelectAllQuery())).thenReturn(preparedStatement);

        when(connection.prepareStatement(articleController.getSelectAllQuery())).thenReturn(preparedStatementForSelectAll);
        when(connection.prepareStatement(roleController.getSelectAllQuery())).thenReturn(preparedStatementForSelectAll);
        when(connection.prepareStatement(userController.getSelectAllQuery())).thenReturn(preparedStatementForSelectAll);

        assertDoesNotThrow(() -> Main.demoCRUD(connection));
    }

    @Test
    @DisplayName("Тестируем метод demoCRUD на NullPointerException в классе Main")
    void demoCRUDWithNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> Main.demoCRUD(null));
        assertNull(exception.getMessage());
    }
}