package application.database;

import application.models.*;

import java.sql.*;
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
    Connection connect = dbEngine.connect();

    public List<User> userListByName(String searchName) {
        //String query = "SELECT * FROM user_table WHERE user_name LIKE " + searchName;
        String builtQuery = new QueryBuilder().select(Table.USER_TABLE).where(Column.USER_NAME, true).build();

        List<User> users = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connect.prepareStatement(builtQuery);
            preparedStatement.setString(1, searchName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String userName = resultSet.getString("user_name");
                String userPw = resultSet.getString("user_password");
                String roleDB = resultSet.getString("user_role").toUpperCase();
                RoleName roleName = RoleName.valueOf(roleDB);
                users.add(new User(id, userName, userPw, roleName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }

        return users;
    }

    public List<User> userListByRole(String role){
        //String query = "SELECT * FROM user_table WHERE user_role LIKE " + role;
        String builtQuery = new QueryBuilder().select(Table.USER_TABLE).where(Column.USER_ROLE, true).build();

        List<User> users = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connect.prepareStatement(builtQuery);
            preparedStatement.setString(1, role);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("id");
                String userName = rs.getString("user_name");
                String userPw = rs.getString("user_password");
                String roleDB = rs.getString("user_role").toUpperCase();
                RoleName roleName = RoleName.valueOf(roleDB);

                users.add(new User(id, userName, userPw, roleName));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }
        return users;
    }

    public List<String> blogsById(String searchId) {
        //String query = "SELECT blog_title FROM blog_to_user WHERE user_id = " + searchId;
        String builtQuery = new QueryBuilder().select(Table.BLOG_TO_USER, Column.BLOG_TITLE).where(Column.USER_ID, false).build();

        try {
            PreparedStatement preparedStatement = connect.prepareStatement(builtQuery);
            preparedStatement.setString(1, searchId);
            ResultSet resultSet = preparedStatement.executeQuery();

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

    public List<String> noteTextsById(String idNum) {
        //String query =  "SELECT note_text FROM note_table WHERE blog_id = " + idNum;
        String builtQuery = new QueryBuilder().select(Table.NOTE_TABLE, Column.NOTE_TEXT).where(Column.BLOG_ID, false).build();
        List<String> result = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connect.prepareStatement(builtQuery);
            preparedStatement.setString(1, idNum);
            ResultSet resultSet = preparedStatement.executeQuery();

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

    public List<String> commentTexts(String rowNum) {
        //String query =  "SELECT comment_text FROM comment_table WHERE note_id LIKE ?";
        String builtQuery = new QueryBuilder().select(Table.COMMENT_TABLE, Column.COMMENT_TEXT).where(Column.NOTE_ID, true).build();
        List<String> comments = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connect.prepareStatement(builtQuery);
            preparedStatement.setString(1, rowNum);
            ResultSet resultSet = preparedStatement.executeQuery();

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
