package ru.innopolis.university.fomin.part1.lesson25.statistic;

import ru.innopolis.university.fomin.part1.lesson25.model.ArticleModel;
import ru.innopolis.university.fomin.part1.lesson25.model.MobileModel;
import ru.innopolis.university.fomin.part1.lesson25.model.RoleModel;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;

/**
 * @author Sergey Fomin
 */
public class ModelVisitor implements Visitor {
    /**
     * Statistic instance
     */
    protected ModelStatistic statistic;

    /**
     * Default constructor
     */
    public ModelVisitor() {
        statistic = new ModelStatistic();
    }

    @Override
    public void visitArticle(ArticleModel article) {
        statistic.incrementTotalCount();
        statistic.incrementCountArticles();

        if (article.getContent().length() >= statistic.getMaxSizeOfArticle()) {
            statistic.setMaxSizeOfArticle(article.getContent().length());
        }

        if (article.getContent().length() < statistic.getMinSizeOfArticle()) {
            statistic.setMinSizeOfArticle(article.getContent().length());
        }
    }

    @Override
    public void visitMobile(MobileModel mobile) {
        statistic.incrementTotalCount();
        statistic.incrementCountMobiles();

        if ("android".equalsIgnoreCase(mobile.getTypeOS())) {
            statistic.incrementCountAndroidPhones();
        }

        if ("ios".equalsIgnoreCase(mobile.getTypeOS())) {
            statistic.incrementCountApplePhones();
        }
    }

    @Override
    public void visitRole(RoleModel role) {
        statistic.incrementTotalCount();
        statistic.incrementCountRoles();
    }

    @Override
    public void visitUser(UserModel user) {
        statistic.incrementTotalCount();
        statistic.incrementCountUsers();
    }

    public ModelStatistic getStatistic() {
        return statistic;
    }
}
