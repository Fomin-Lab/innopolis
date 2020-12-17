package ru.innopolis.university.fomin.part1.lesson25.statistic;

import ru.innopolis.university.fomin.part1.lesson25.model.ArticleModel;
import ru.innopolis.university.fomin.part1.lesson25.model.MobileModel;
import ru.innopolis.university.fomin.part1.lesson25.model.RoleModel;
import ru.innopolis.university.fomin.part1.lesson25.model.UserModel;

/**
 * @author Sergey Fomin
 */
public interface Visitor {
    void visitArticle(ArticleModel article);
    void visitMobile(MobileModel mobile);
    void visitRole(RoleModel role);
    void visitUser(UserModel user);
}
