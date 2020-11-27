package ru.innopolis.university.fomin.part1.lesson22.scheme;

/**
 * Scheme of the blog database
 */
public class BlogDbScheme {
    /**
     * Database name
     */
    public static final String NAME = "db_blog";

    /**
     * Table of articles
     */
    public static final class ArticleTable {
        /**
         * Name of the table
         */
        public static final String NAME = "bg_articles";
    }

    /**
     * Table of roles
     */
    public static final class RolesTable {
        /**
         * Name of the table
         */
        public static final String NAME = "bg_roles";
    }

    /**
     * Table of users
     */
    public static final class UsersTable {
        /**
         * Name of the table
         */
        public static final String NAME = "bg_users";
    }
}
