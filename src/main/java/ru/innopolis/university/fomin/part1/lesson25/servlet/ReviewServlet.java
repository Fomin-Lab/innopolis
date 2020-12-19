package ru.innopolis.university.fomin.part1.lesson25.servlet;

import ru.innopolis.university.fomin.part1.lesson25.controllers.ArticleController;
import ru.innopolis.university.fomin.part1.lesson25.controllers.MobileController;
import ru.innopolis.university.fomin.part1.lesson25.controllers.RoleController;
import ru.innopolis.university.fomin.part1.lesson25.controllers.UserController;
import ru.innopolis.university.fomin.part1.lesson25.model.ArticleModel;
import ru.innopolis.university.fomin.part1.lesson25.model.MobileModel;
import ru.innopolis.university.fomin.part1.lesson25.model.RoleModel;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;
import ru.innopolis.university.fomin.part1.lesson25.statistic.ModelVisitor;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Review servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/")
public class ReviewServlet extends HttpServlet {
    /**
     * Controller for users
     */
    @Inject
    protected UserController userController;

    /**
     * Controller for roles
     */
    @Inject
    protected RoleController roleController;

    /**
     * Controller for articles
     */
    @Inject
    protected ArticleController articleController;

    /**
     * Controller for mobiles
     */
    @Inject
    protected MobileController mobileController;

    /**
     * Send data on view
     *
     * @param req  Request
     * @param resp Response
     * @throws ServletException if occur servlet error
     * @throws IOException      if occur io error
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserModel> users = userController.getAll();
        List<RoleModel> roles = roleController.getAll();
        List<MobileModel> mobiles = mobileController.getAll();
        List<ArticleModel> articles = articleController.getAll();

        ModelVisitor visitor = new ModelVisitor();
        users.forEach(model -> model.accept(visitor));
        roles.forEach(model -> model.accept(visitor));
        mobiles.forEach(model -> model.accept(visitor));
        articles.forEach(model -> model.accept(visitor));

        req.setAttribute("users", users);
        req.setAttribute("articles", articles);
        req.setAttribute("roles", roles);
        req.setAttribute("mobiles", mobiles);
        req.setAttribute("statistic", visitor.getStatistic());
        req.setAttribute("PageTitle", "Review page");
        req.setAttribute("PageBody", "review.jsp");
        req.getRequestDispatcher("jsp/layout.jsp").forward(req, resp);
    }
}
