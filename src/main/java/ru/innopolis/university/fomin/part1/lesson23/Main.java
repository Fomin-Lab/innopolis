package ru.innopolis.university.fomin.part1.lesson23;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.university.fomin.part1.lesson23.dao.ArticleController;
import ru.innopolis.university.fomin.part1.lesson23.dao.RoleController;
import ru.innopolis.university.fomin.part1.lesson23.dao.UserController;
import ru.innopolis.university.fomin.part1.lesson23.connection.PostgreConnectionManager;
import ru.innopolis.university.fomin.part1.lesson23.model.RoleModel;
import ru.innopolis.university.fomin.part1.lesson23.model.UserModel;

import java.sql.*;

/**
 * Class performs the task conditions lesson19 task2
 */
public class Main {

    /**
     * Slf4j wrapper
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * Entry point execute demo examples
     *
     * @param args Input args
     * @throws SQLException If occur sql exception
     */
    public static void main(String[] args) throws SQLException {
        LOGGER.trace("start app");

        Connection connection = new PostgreConnectionManager().getConnection();

        demoSavepoint(connection);

        if (connection.getMetaData().supportsBatchUpdates()) {
            demoBatch(connection);
        }

        demoCRUD(connection);
    }

    /**
     * Demo CRUD operations
     *
     * @param connection Jdbc connection
     */
    public static void demoCRUD(Connection connection) throws SQLException {
        LOGGER.trace("start demoCRUD");

        ArticleController articleController = new ArticleController(connection);
        RoleController roleController = new RoleController(connection);
        UserController userController = new UserController(connection);

        // create
        roleController.create(new RoleModel("Редактор"));
        LOGGER.info("Create new entry");

        // read
        RoleModel roleModel = roleController.getEntityById(4);
        LOGGER.info("Read entry");

        // update
        roleModel.setTitle("Root");
        roleController.update(roleModel);
        LOGGER.info("Update entry");

        // delete
        userController.delete(1);
        LOGGER.info("Delete entry");

        // read all
        LOGGER.info("Всего статей: " + articleController.getAll().size());
        LOGGER.info("Всего ролей: " + roleController.getAll().size());
        LOGGER.info("Всего пользователей: " + userController.getAll().size());
    }

    /**
     * Demo savepoint and rollback
     *
     * @param connection Jdbc connection
     * @throws SQLException If occur sql connection
     */
    public static void demoSavepoint(Connection connection) throws SQLException {
        LOGGER.trace("start demoSavepoint");

        connection.setAutoCommit(false);

        UserModel user1 = new UserModel("Dima", "dima", 1, 1);
        UserModel user2 = new UserModel("Katya", "katya", 2, 2);
        UserModel user3 = new UserModel("Annya", "anna", 3, 3);

        UserController userController = new UserController(connection);

        userController.create(user1);
        userController.create(user2);

        // savepoint
        Savepoint savepoint = connection.setSavepoint();

        userController.create(user3);

        // user3 not created
        connection.rollback(savepoint);

        connection.commit();
    }

    /**
     * Demo execute batch
     *
     * @param connection Jdbc connection
     * @throws SQLException If occur sql connection
     */
    public static void demoBatch(Connection connection) throws SQLException {
        LOGGER.trace("start demoBatch");

        connection.setAutoCommit(false);

        UserController controller = new UserController(connection);
        UserModel user1 = new UserModel("Dima1", "dima1", 1, 11);
        UserModel user2 = new UserModel("Katya1", "katya1", 2, 22);
        UserModel user3 = new UserModel("Annya1", "anna1", 3, 33);

        // insert with batch
        try (PreparedStatement statement = connection.prepareStatement(controller.getInsertQuery())) {
            user1.sendToPreparedStatement(statement, false);
            statement.addBatch();

            user2.sendToPreparedStatement(statement, false);
            statement.addBatch();

            user3.sendToPreparedStatement(statement, false);
            statement.addBatch();

            statement.executeBatch();
            connection.commit();
        }

        // update with batch
        try (PreparedStatement statement = connection.prepareStatement(controller.getUpdateQuery())) {
            user1.setId(1);
            user1.sendToPreparedStatement(statement, true);
            statement.addBatch();

            user2.setId(2);
            user2.sendToPreparedStatement(statement, true);
            statement.addBatch();

            user3.setId(4);
            user3.sendToPreparedStatement(statement, true);
            statement.addBatch();

            statement.executeBatch();
            connection.commit();
        }
    }
}
