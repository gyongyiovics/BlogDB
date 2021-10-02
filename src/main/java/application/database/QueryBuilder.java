package application.database;

/**
 * visszaadja adott szerepkörű felhasználók összes adatát
 * SELECT * FROM user WHERE role IS ...;
 * visszaadja egy adott felhasználó összes adatát:
 * SELECT * FROM user WHERE user_name IS ...;
 * visszaadja egy adott felhasználó összes blogját
 * SELECT blog_text FROM ... WHERE user_name IS ...;
 * visszaadja egy adott blog összes blogbejegyzését
 * SELECT blog_text FROM ... WHERE blog is ...;
 * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
 * SELECT comment_text FROM ... WHERE blog_text IS ...;
 */

public class QueryBuilder {
    private StringBuilder query;

    public QueryBuilder() {
        query = new StringBuilder();
    }

    //SELECT
    /*public QueryBuilder select(Table table, Column... columns) {
        query.append("SELECT ");
        if (columns.length > 0) {
            addColumns(columns);
        } else {
            query.append("*");
        }

        query.append(" FROM ").append(EnumHelper.getDBName(table));
        return this;
    }

    //WHERE
    public QueryBuilder where(Column column, boolean useLike) {
        query.append(" WHERE ")
                .append(EnumHelper.getDBName(column))
                .append((useLike ? " LIKE " : " = "))
                .append("?");
        return this;
    }*/
}
