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

/**
 * Tests for ArticleModel class
 */
class ArticleModelTest {
    /**
     * Model instance
     */
    protected ArticleModel model;

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
        model = new ArticleModel("article title", "article content", 3, 5);
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
     * Test on success for getter/setter content field
     *
     * @param content Test words
     */
    @ParameterizedTest
    @ValueSource(strings = {"c1", "c2", "article content"})
    void getSetContent(String content) {
        model.setContent(content);
        assertEquals(content, model.getContent());
    }

    /**
     * Test on success for getter/setter authorId field
     *
     * @param authorId Test numbers
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5000, 34384, -5})
    void getSetAuthorId(int authorId) {
        model.setAuthorId(authorId);
        assertEquals(authorId, model.getAuthorId());
    }

    /**
     * Test on success for getter/setter likes field
     *
     * @param likes Test numbers
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5000, 34384, -5})
    void getSetLikes(int likes) {
        model.setLikes(likes);
        assertEquals(likes, model.getLikes());
    }

    /**
     * Test on success for loadFromResultSet method in ArticleModel class
     *
     * @throws SQLException If occur sql error
     */
    @Test
    void loadFromResultSet() throws SQLException {
        int id = 12;
        String title = "Статья для шахтёров";
        String content = "Когда смотришь, как работают шахтеры...";
        int authorId = 4;
        int likes = 7;

        when(resultSet.getInt(1)).thenReturn(id);
        when(resultSet.getString(2)).thenReturn(title);
        when(resultSet.getString(3)).thenReturn(content);
        when(resultSet.getInt(4)).thenReturn(authorId);
        when(resultSet.getInt(5)).thenReturn(likes);

        model.loadFromResultSet(resultSet);

        assertEquals(id, model.getId());
        assertEquals(title, model.getTitle());
        assertEquals(content, model.getContent());
        assertEquals(authorId, model.getAuthorId());
        assertEquals(likes, model.getLikes());
    }
}