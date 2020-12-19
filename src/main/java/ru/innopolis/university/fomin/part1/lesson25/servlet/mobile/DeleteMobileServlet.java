package ru.innopolis.university.fomin.part1.lesson25.servlet.mobile;

import ru.innopolis.university.fomin.part1.lesson25.controllers.AbstractController;
import ru.innopolis.university.fomin.part1.lesson25.controllers.MobileController;
import ru.innopolis.university.fomin.part1.lesson25.model.MobileModel;
import ru.innopolis.university.fomin.part1.lesson25.servlet.DeleteServlet;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

/**
 * Delete mobile servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/mobile-delete")
public class DeleteMobileServlet extends DeleteServlet<MobileModel> {
    /**
     * Controller
     */
    @Inject
    private MobileController mobileController;

    /**
     * Used controller for deletion
     *
     * @return Controller instance
     */
    @Override
    protected AbstractController<MobileModel> getController() {
        return mobileController;
    }
}
