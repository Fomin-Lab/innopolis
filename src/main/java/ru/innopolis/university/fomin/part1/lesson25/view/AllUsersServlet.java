package ru.innopolis.university.fomin.part1.lesson25.view;

import ru.innopolis.university.fomin.part1.lesson25.dao.UserController;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class AllUsersServlet extends HttpServlet {
    @Inject
    private UserController userController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserModel> allUsers = userController.getAll();
        req.setAttribute("users", allUsers);

        req.getRequestDispatcher("WEB-INF/jsp/all-users.jsp").forward(req, resp);
    }
}
