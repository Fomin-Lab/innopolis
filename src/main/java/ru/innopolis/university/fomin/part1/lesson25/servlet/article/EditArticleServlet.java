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
 * Edit article servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/article-edit")
public class EditArticleServlet extends HttpServlet {
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
        String id = req.getParameter("id");

        if (id == null) {
            resp.setStatus(404);
            req.setAttribute("PageBody", "jsp/not-found.jsp");
            req.getRequestDispatcher("/layout.jsp").forward(req, resp);
        } else {
            ArticleModel article = articleController.getEntityById(Integer.parseInt(id));
            req.setAttribute("article", article);
            req.setAttribute("PageTitle", "Article edit");
            req.setAttribute("PageBody", "forms/article-form.jsp");
            req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
        }
    }

    /**
     * Update article model
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        ArticleModel articleModel = new ArticleModel(
                req.getParameter("title"),
                req.getParameter("content"),
                Integer.parseInt(req.getParameter("author_id")),
                Integer.parseInt(req.getParameter("likes"))
        );

        articleModel.setId(Integer.parseInt(req.getParameter("id")));
        articleController.update(articleModel);

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
