package ru.innopolis.university.fomin.part1.lesson25.servlet.user;

import ru.innopolis.university.fomin.part1.lesson25.controllers.AbstractController;
import ru.innopolis.university.fomin.part1.lesson25.controllers.UserController;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;
import ru.innopolis.university.fomin.part1.lesson25.servlet.DeleteServlet;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

/**
 * Delete user servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/user-delete")
public class DeleteUserServlet extends DeleteServlet<UserModel> {
    /**
     * Controller
     */
    @Inject
    private UserController userController;

    /**
     * Used controller for deletion
     *
     * @return Controller instance
     */
    @Override
    protected AbstractController<UserModel> getController() {
        return userController;
    }
}
