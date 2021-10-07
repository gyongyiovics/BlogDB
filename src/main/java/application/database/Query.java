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
 * mysql: SELECT note_text FROM note_table WHERE user_name LIKE 'Jancsi@45';
 * visszaadja egy adott blog összes blogbejegyzését
 * mysql: SELECT note_text FROM note_table WHERE blog_id LIKE 2;
 * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
 * mysql: SELECT comment_text FROM comment_table WHERE note_id LIKE 1;
 **/

public class Query {
    List<String> texts = new ArrayList<>();
    DBEngine dbEngine = new DBEngine();

    public List<User> userList(String row, String searchName) {
        String query = "SELECT * FROM user_table WHERE " + row + " LIKE " + searchName;
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

    //TODO: type of Long or String
    public List<String> noteTexts(String row, String searchText) {
        String query =  "SELECT note_text FROM note_table WHERE " + row + " LIKE " + searchText;
        //List<String> texts = new ArrayList<>();
        //List<Long> ids = new ArrayList<>();
        //Note note = null;

        try {
            Statement statement = dbEngine.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String noteText = resultSet.getString("note_text");
                //long blogId = resultSet.getLong("blog_id");
                texts.add(noteText);
                //ids.add(blogId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }
        return texts;
    }


    public List<String> noteTextsFromId(String row, long idNum) {
        String query =  "SELECT note_text FROM note_table WHERE " + row + " = " + idNum;
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
