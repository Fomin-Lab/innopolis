package ru.innopolis.university.fomin.part1.lesson25.servlet.role;

import ru.innopolis.university.fomin.part1.lesson25.controllers.RoleController;
import ru.innopolis.university.fomin.part1.lesson25.model.RoleModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Edit role servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/role-edit")
public class EditRoleServlet extends HttpServlet {
    /**
     * Controller
     */
    @Inject
    private RoleController roleController;

    /**
     * Send form
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id == null) {
            resp.setStatus(404);
            req.setAttribute("PageBody", "jsp/not-found.jsp");
            req.getRequestDispatcher("/layout.jsp").forward(req, resp);
        } else {
            RoleModel role = roleController.getEntityById(Integer.parseInt(id));
            req.setAttribute("role", role);
            req.setAttribute("PageTitle", "Role edit");
            req.setAttribute("PageBody", "forms/role-form.jsp");
            req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
        }
    }

    /**
     * Update role model
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        RoleModel role = new RoleModel(
                req.getParameter("title")
        );

        role.setId(Integer.parseInt(req.getParameter("id")));
        roleController.update(role);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
