package ru.innopolis.university.fomin.part1.lesson25.servlet.article;

import ru.innopolis.university.fomin.part1.lesson25.controllers.ArticleController;
import ru.innopolis.university.fomin.part1.lesson25.model.ArticleModel;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Create article servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/article-create")
public class CreateArticleServlet extends HttpServlet {
    /**
     * Controller
     */
    @Inject
    private ArticleController articleController;

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
        req.setAttribute("PageTitle", "Article create");
        req.setAttribute("PageBody", "forms/article-form.jsp");
        req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
    }

    /**
     * Create article model
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        articleController.create(new ArticleModel(
                req.getParameter("title"),
                req.getParameter("content"),
                Integer.parseInt(req.getParameter("author_id")),
                Integer.parseInt(req.getParameter("likes"))
        ));

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
