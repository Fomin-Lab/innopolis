package ru.innopolis.university.fomin.part1.lesson25.servlet;

import ru.innopolis.university.fomin.part1.lesson25.controllers.UserController;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Sergey Fomin
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
        req.setAttribute("PageTitle", "Login");
        req.setAttribute("PageBody", "login.jsp");
        req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
    }

    /**
     * Log In
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        System.out.println("login: " + login);
        System.out.println("password: " + password);

        UserModel model = userController.getUserByCredentials(login, password);
        if (model != null) {
            HttpSession session = req.getSession(false);
            session.setAttribute("loggedUser", true);

            String requestedUrl = (String) session.getAttribute("requestedUrl");
            if (requestedUrl != null) {
                resp.sendRedirect(requestedUrl);
            } else {
                resp.sendRedirect("/");
            }
        } else {
            req.setAttribute("PageTitle", "Login");
            req.setAttribute("PageBody", "login.jsp");
            req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
        }
    }
}
