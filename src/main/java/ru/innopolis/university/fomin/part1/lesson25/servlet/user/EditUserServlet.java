package ru.innopolis.university.fomin.part1.lesson25.servlet.user;

import ru.innopolis.university.fomin.part1.lesson25.controllers.UserController;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Edit user servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/user-edit")
public class EditUserServlet extends HttpServlet {
    /**
     * Controller
     */
    @Inject
    private UserController userController;

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
            UserModel user = userController.getEntityById(Integer.parseInt(id));
            req.setAttribute("user", user);
            req.setAttribute("PageTitle", "User edit");
            req.setAttribute("PageBody", "forms/user-form.jsp");
            req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
        }
    }

    /**
     * Update user model
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserModel user = new UserModel(
                req.getParameter("login"),
                req.getParameter("name"),
                Integer.parseInt(req.getParameter("role_id")),
                Integer.parseInt(req.getParameter("rate"))
        );

        user.setId(Integer.parseInt(req.getParameter("id")));
        userController.update(user);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
