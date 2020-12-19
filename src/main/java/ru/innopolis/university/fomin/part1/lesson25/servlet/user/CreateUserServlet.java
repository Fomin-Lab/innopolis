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
 * Create user servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/user-create")
public class CreateUserServlet extends HttpServlet {
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
        req.setAttribute("PageTitle", "User create");
        req.setAttribute("PageBody", "forms/user-form.jsp");
        req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
    }

    /**
     * Create user model
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        userController.create(new UserModel(
                req.getParameter("login"),
                req.getParameter("name"),
                Integer.parseInt(req.getParameter("role_id")),
                Integer.parseInt(req.getParameter("rate"))
        ));

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
