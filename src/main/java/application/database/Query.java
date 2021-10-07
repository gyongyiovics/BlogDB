package application.database;

import application.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * visszaadja adott szerepkörű felhasználók összes adatát
 * mysql: SELECT * FROM user_table WHERE user_role LIKE 'ADMIN';
 * visszaadja egy adott felhasználó összes adatát:
 * mysql: SELECT * FROM user_table WHERE user_name LIKE 'Gizi@123';
 * visszaadja egy adott felhasználó összes blogját
 * mysql: SELECT blog_title FROM blog_to_user WHERE user_id = 1;
 * visszaadja egy adott blog összes blogbejegyzését
 * mysql: SELECT note_text FROM note_table WHERE blog_id = 2;
 * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
 * mysql: SELECT comment_text FROM comment_table WHERE note_id = 1;
 **/

public class Query {
    List<String> texts = new ArrayList<>();
    DBEngine dbEngine = new DBEngine();
    QueryBuilder queryBuilder = new QueryBuilder();


    public List<User> userListByName(String searchName) {
        //TODO: query statement thingy, builder

        String query = "SELECT * FROM user_table WHERE user_name LIKE " + searchName;
        List<User> users = new ArrayList<>();
        User user = null;

        try {
            Statement statement = dbEngine.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String userName = resultSet.getString("user_name");
                String userPw = resultSet.getString("user_password");
                String roleDB = resultSet.getString("user_role").toUpperCase();
                RoleName roleName = RoleName.valueOf(roleDB);

                user = new User(id, userName, userPw, roleName);
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }

        return users;
    }

    public List<User> userListByRole(String role){
        String query = "SELECT * FROM user_table WHERE user_role LIKE " + role;
        List<User> userList = new ArrayList<>();
        User user = null;

        try {
            Statement statement = dbEngine.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String userName = resultSet.getString("user_name");
                String userPw = resultSet.getString("user_password");
                String roleDB = resultSet.getString("user_role").toUpperCase();
                RoleName roleName = RoleName.valueOf(roleDB);

                user = new User(id, userName, userPw, roleName);
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }

        return userList;
    }

    public List<String> blogsById(String row, long searchId) {
        String query = "SELECT blog_title FROM blog_to_user WHERE " + row + " = " + searchId;

        try {
            Statement statement = dbEngine.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String noteText = resultSet.getString("blog_title");
                texts.add(noteText);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }
        return texts;
    }

    public List<String> noteTextsById(String row, long idNum) {
        String query =  "SELECT note_text FROM note_table WHERE " + row + " = " + idNum;
        //String builtQuery = queryBuilder.select().where().build();
        List<String> result = new ArrayList<>();

        try {
            Statement statement = dbEngine.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String noteText = resultSet.getString("note_text");
                result.add(noteText);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }
        return result;
    }

    public List<String> commentTexts(String row, String rowNum) {
        String query =  "SELECT comment_text FROM comment_table WHERE " + row + " LIKE " + rowNum;
        List<String> comments = new ArrayList<>();

        try {
            Statement statement = dbEngine.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String commentText = resultSet.getString("comment_text");
                comments.add(commentText);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }
        return comments;
    }

}
