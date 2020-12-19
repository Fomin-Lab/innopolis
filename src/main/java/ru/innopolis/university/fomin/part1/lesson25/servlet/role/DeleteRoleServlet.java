package ru.innopolis.university.fomin.part1.lesson25.servlet.role;

import ru.innopolis.university.fomin.part1.lesson25.controllers.AbstractController;
import ru.innopolis.university.fomin.part1.lesson25.controllers.RoleController;
import ru.innopolis.university.fomin.part1.lesson25.model.RoleModel;
import ru.innopolis.university.fomin.part1.lesson25.servlet.DeleteServlet;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

/**
 * Delete role servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/role-delete")
public class DeleteRoleServlet extends DeleteServlet<RoleModel> {
    /**
     * Controller
     */
    @Inject
    private RoleController roleController;

    /**
     * Used controller for deletion
     *
     * @return Controller instance
     */
    @Override
    protected AbstractController<RoleModel> getController() {
        return roleController;
    }
}
