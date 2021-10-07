package application.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryBuilderTest {

    @Test
    void selectTest() {
        String query1 = "SELECT user_password FROM user_table;";
        String query2 = "SELECT * FROM user_table;";

        String builtQuery1 = new QueryBuilder().select(Table.USER_TABLE, Column.USER_PASSWORD).build();
        String builtQuery2 = new QueryBuilder().select(Table.USER_TABLE).build();

        Assertions.assertEquals(query1, builtQuery1);
        Assertions.assertEquals(query2, builtQuery2);
    }

    @Test
    void whereTest() {
        String query1 = " WHERE user_password LIKE ?;";
        String query2 = " WHERE user_id = ?;";

        String builtQuery1 = new QueryBuilder().where(Column.USER_PASSWORD, true).build();
        String builtQuery2 = new QueryBuilder().where(Column.USER_ID, false).build();

        Assertions.assertEquals(query1, builtQuery1);
        Assertions.assertEquals(query2, builtQuery2);
    }

    /*@Test
    void selectAggregate() {
        String query = "";
    }*/

    @Test
    void addColumnsTest() {}

    @Test
    void prepareValuesTest() {}

    @Test
    void buildTest() {
        String text = ";";
        Assertions.assertEquals(text, new QueryBuilder().build());
        
    }
}