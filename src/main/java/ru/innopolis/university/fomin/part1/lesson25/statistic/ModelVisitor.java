package ru.innopolis.university.fomin.part1.lesson25.statistic;

import ru.innopolis.university.fomin.part1.lesson25.model.ArticleModel;
import ru.innopolis.university.fomin.part1.lesson25.model.MobileModel;
import ru.innopolis.university.fomin.part1.lesson25.model.RoleModel;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;

/**
 * @author Sergey Fomin
 */
public class ModelVisitor implements Visitor {
    protected int totalCount = 0;
    protected int countArticles = 0;
    protected int countMobiles = 0;
    protected int countRoles = 0;
    protected int countUsers = 0;
    protected long maxSizeOfArticle = 0;
    protected long minSizeOfArticle = Long.MAX_VALUE;
    protected long countAndroidPhones = 0;
    protected long countApplePhones = 0;

    @Override
    public void visitArticle(ArticleModel article) {
        totalCount++;
        countArticles++;

        if (article.getContent().length() >= maxSizeOfArticle) {
            maxSizeOfArticle = article.getContent().length();
        }

        if (article.getContent().length() < minSizeOfArticle) {
            minSizeOfArticle = article.getContent().length();
        }
    }

    @Override
    public void visitMobile(MobileModel mobile) {
        totalCount++;
        countMobiles++;

        if ("android".equals(mobile.getTypeOS())) {
            countAndroidPhones++;
        }

        if ("ios".equals(mobile.getTypeOS())) {
            countApplePhones++;
        }
    }

    @Override
    public void visitRole(RoleModel role) {
        totalCount++;
        countRoles++;
    }

    @Override
    public void visitUser(UserModel user) {
        totalCount++;
        countUsers++;
    }
}
