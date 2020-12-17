package ru.innopolis.university.fomin.part1.lesson25.servlet;

import ru.innopolis.university.fomin.part1.lesson25.controllers.UserController;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/show-user")
public class UserServlet extends HttpServlet {
    @Inject
    private UserController userController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final UserModel user = userController.getEntityById(Integer.parseInt(id));

        req.setAttribute("PageTitle", "User");

        if (user == null) {
            resp.setStatus(404);
            req.setAttribute("PageBody", "jsp/not-found.jsp");
            req.getRequestDispatcher("/layout.jsp").forward(req, resp);
        } else {
            req.setAttribute("user", user);
            req.setAttribute("PageBody", "show-user.jsp");
            req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
        }
    }
}