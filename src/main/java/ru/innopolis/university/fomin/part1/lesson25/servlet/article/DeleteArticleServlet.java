package ru.innopolis.university.fomin.part1.lesson25.servlet.article;

import ru.innopolis.university.fomin.part1.lesson25.controllers.AbstractController;
import ru.innopolis.university.fomin.part1.lesson25.controllers.ArticleController;
import ru.innopolis.university.fomin.part1.lesson25.model.ArticleModel;
import ru.innopolis.university.fomin.part1.lesson25.servlet.DeleteServlet;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

/**
 * Delete article servlet
 *
 * @author Sergey Fomin
 */
@WebServlet("/article-delete")
public class DeleteArticleServlet extends DeleteServlet<ArticleModel> {
    /**
     * Controller
     */
    @Inject
    private ArticleController articleController;

    /**
     * Used controller for deletion
     *
     * @return Controller instance
     */
    @Override
    protected AbstractController<ArticleModel> getController() {
        return articleController;
    }
}
