package ru.innopolis.university.fomin.part1.lesson25.servlet;

import ru.innopolis.university.fomin.part1.lesson25.controllers.AbstractController;
import ru.innopolis.university.fomin.part1.lesson25.model.AbstractModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Sergey Fomin
 */
public abstract class DeleteServlet<T extends AbstractModel> extends HttpServlet {
    /**
     * Delete model
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
            getController().delete(Integer.parseInt(id));
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    /**
     * @return Controller
     */
    protected abstract AbstractController<T> getController();
}
