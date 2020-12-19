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
 * Create role servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/role-create")
public class CreateRoleServlet extends HttpServlet {
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
        req.setAttribute("PageTitle", "Role create");
        req.setAttribute("PageBody", "forms/role-form.jsp");
        req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
    }

    /**
     * Create role model
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        roleController.create(new RoleModel(
                req.getParameter("title")
        ));

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
