package ru.innopolis.university.fomin.part1.lesson25.statistic;

/**
 * @author Sergey Fomin
 */
public class ModelStatistic {
    protected int totalCount = 0;
    protected int countArticles = 0;
    protected int countMobiles = 0;
    protected int countRoles = 0;
    protected int countUsers = 0;
    protected long maxSizeOfArticle = 0;
    protected long minSizeOfArticle = Long.MAX_VALUE;
    protected long countAndroidPhones = 0;
    protected long countApplePhones = 0;

    void incrementTotalCount() {
        totalCount++;
    }

    void incrementCountArticles() {
        countArticles++;
    }

    void incrementCountMobiles() {
        countMobiles++;
    }

    void incrementCountRoles() {
        countRoles++;
    }

    void incrementCountUsers() {
        countUsers++;
    }

    void incrementCountAndroidPhones() {
        countAndroidPhones++;
    }

    void incrementCountApplePhones() {
        countApplePhones++;
    }

    public void setMaxSizeOfArticle(long maxSizeOfArticle) {
        this.maxSizeOfArticle = maxSizeOfArticle;
    }

    public void setMinSizeOfArticle(long minSizeOfArticle) {
        this.minSizeOfArticle = minSizeOfArticle;
    }

    public int getCountArticles() {
        return countArticles;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getCountMobiles() {
        return countMobiles;
    }

    public int getCountRoles() {
        return countRoles;
    }

    public int getCountUsers() {
        return countUsers;
    }

    public long getMaxSizeOfArticle() {
        return maxSizeOfArticle;
    }

    public long getMinSizeOfArticle() {
        return minSizeOfArticle;
    }

    public long getCountAndroidPhones() {
        return countAndroidPhones;
    }

    public long getCountApplePhones() {
        return countApplePhones;
    }
}
