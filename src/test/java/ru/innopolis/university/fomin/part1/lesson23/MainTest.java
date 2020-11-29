package ru.innopolis.university.fomin.part1.lesson23;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.university.fomin.part1.lesson23.connection.ConnectionManager;
import ru.innopolis.university.fomin.part1.lesson23.mocks.ConnectionManagerMock;

import java.sql.Connection;


import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final Logger LOGGER = LoggerFactory.getLogger("testing");

    protected Connection connection;
    protected ConnectionManager connectionManager;

    @BeforeEach
    void setUp() {
        LOGGER.trace("setUp");
        connectionManager = new ConnectionManagerMock();
        connection = connectionManager.getConnection();
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
    void demoCRUDWithOk() {
        assertDoesNotThrow(() -> Main.demoCRUD(connection));
    }

    @Test
    @DisplayName("Тестируем метод demoCRUD на NullPointerException в классе Main")
    void demoCRUDWithNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> Main.demoCRUD(null));
        assertNull(exception.getMessage());
    }
}