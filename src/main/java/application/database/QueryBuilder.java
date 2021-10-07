package application.database;

import application.helpers.EnumHelper;

import java.util.List;

/**
 * visszaadja adott szerepkörű felhasználók összes adatát
 * SELECT * FROM user WHERE role IS ...;
 * visszaadja egy adott felhasználó összes adatát:
 * SELECT * FROM user WHERE user_name IS ...;
 * visszaadja egy adott felhasználó összes blogját
 * SSELECT blog_title FROM blog_to_user WHERE user_id = 1;
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
    public QueryBuilder select(Table table, Column... columns) {
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
    }

    //AGGREGATED
    /*public QueryBuilder selectAggregate(Table table, String aggregatedName, String asText, Column... columns) {
        query.append("SELECT ")
                .append(aggregatedName)
                .append("(*)")
                .append(" AS ")
                .append(asText)
                .append(" FROM ").append(EnumHelper.getDBName(table));
        return this;
    }*/

    private void addColumns(Column... columns) {
        for (Column column: columns) {
            query.append(EnumHelper.getDBName(column)).append(", ");
        }
        query.setLength(query.length() - 2);
    }

    private void prepareValues(int repeat) {
        query.append("VALUES (")
                .append("?,".repeat(repeat));
        query.setLength(query.length() - 1);
        query.append(")");
    }

    public String build() {
        query.append(";");
        return query.toString();
    }

}
