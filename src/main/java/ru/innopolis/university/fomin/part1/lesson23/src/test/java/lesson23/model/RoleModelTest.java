package lesson23.model;

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

class RoleModelTest {
    /**
     * Model instance
     */
    protected RoleModel model;

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
        model = new RoleModel("role title");
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
     * Test on success for getter/setter title field
     *
     * @param title Test words
     */
    @ParameterizedTest
    @ValueSource(strings = {"a1", "a2", "article title"})
    void getSetTitle(String title) {
        model.setTitle(title);
        assertEquals(title, model.getTitle());
    }

    /**
     * Test on success for loadFromResultSet method in RoleModel class
     *
     * @throws SQLException If occur sql error
     */
    @Test
    void loadFromResultSet() throws SQLException {
        int id = 15;
        String title = "Агент";

        when(resultSet.getInt(1)).thenReturn(id);
        when(resultSet.getString(2)).thenReturn(title);

        model.loadFromResultSet(resultSet);

        assertEquals(id, model.getId());
        assertEquals(title, model.getTitle());
    }
}