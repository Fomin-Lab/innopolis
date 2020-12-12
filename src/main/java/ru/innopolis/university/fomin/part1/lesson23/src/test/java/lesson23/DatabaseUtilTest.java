package lesson23;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lesson23.connection.ConnectionFactory;
import lesson23.connection.DatabaseType;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 * Tests for DatabaseUtil class
 */
class DatabaseUtilTest {
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
    protected Statement statement;

    /**
     * Static mock
     */
    protected static MockedStatic<ConnectionFactory> connectionFactoryMock;

    /**
     * Execute before all tests
     */
    @BeforeAll
    static void setUpAll() {
        connectionFactoryMock = mockStatic(ConnectionFactory.class);
    }

    /**
     * Execute before each the test
     */
    @BeforeEach
    void setUp() throws SQLException {
        openMocks(this);

        connectionFactoryMock.when(() -> ConnectionFactory.getConnection(DatabaseType.DEFAULT)).then(invocationOnMock -> connection);
        connectionFactoryMock.when(() -> ConnectionFactory.getConnection(DatabaseType.BLOG)).then(invocationOnMock -> connection);

        when(connection.createStatement()).thenReturn(statement);
    }

    /**
     * Test on success for method renewDatabase in DatabaseUtil class
     */
    @Test
    void renewDatabase() {
        assertDoesNotThrow(DatabaseUtil::renewDatabase);
    }

    /**
     * Test on success for method renewTables in DatabaseUtil class
     */
    @Test
    void renewTables() {
        assertDoesNotThrow(DatabaseUtil::renewTables);
    }

    /**
     * Test on success for method insertSomeLines in DatabaseUtil class
     */
    @Test
    void insertSomeLines() {
        assertDoesNotThrow(DatabaseUtil::insertSomeLines);
    }

    /**
     * Test on success for method getConnectionString in DatabaseUtil class
     *
     * @param input Test phrase
     */
    @ParameterizedTest
    @MethodSource("argsForGetConnectionString")
    void getConnectionString(String input) {
        LOGGER.debug("Input arg is null: " + (input == null));
        boolean result = DatabaseUtil.getConnectionString(input).startsWith("jdbc:postgresql://");
        assertTrue(result);
    }

    /**
     * Use in @MethodSource
     *
     * @return Stream with arguments
     */
    private static Stream<Arguments> argsForGetConnectionString() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of("db_blog"),
                Arguments.of(""),
                Arguments.of(DatabaseUtil.DB_NAME)
        );
    }
}