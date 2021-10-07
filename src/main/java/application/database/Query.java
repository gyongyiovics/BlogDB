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
 * mysql: SELECT note_text FROM note_table WHERE blog_id = 2;
 * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
 * mysql: SELECT comment_text FROM comment_table WHERE note_id = 1;
 **/

public class Query {
    DBEngine dbEngine = new DBEngine();

    public List<User> userList(String row, String searchName) {
        String query = "SELECT * FROM user_table WHERE " + row + " IS " + searchName;
        List<User> users = new ArrayList<>();
        User user = null;

        try {
            Statement statement = dbEngine.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String userName = resultSet.getString("user_name");
                String userPw = resultSet.getString("user_password");
                String roleDB = resultSet.getNString("user").toUpperCase();
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

    public List<String> noteTexts(String row, String searchText) {
        String query =  "SELECT note_text FROM note_table WHERE " + row + " LIKE " + searchText;
        List<String> texts = new ArrayList<>();
        Note note = null;

        try {
            Statement statement = dbEngine.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String noteText = resultSet.getString("note_text");
                String userName = resultSet.getString("user_name");
                boolean hasComment = resultSet.getBoolean("has_comment");
                String state = resultSet.getString("state");
                long blogId = resultSet.getLong("blog_id");

                note = new Note(id, noteText, userName, hasComment, state, blogId);
                texts.add(note.getNoteText());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }
        return texts;
    }

    public List<String> commentTexts(String row, String searchText) {
        String query =  "SELECT comment_text FROM comment_table WHERE " + row + " LIKE " + searchText;
        List<String> comments = new ArrayList<>();
        Comment comment = null;

        try {
            Statement statement = dbEngine.connect().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                long commentId = resultSet.getLong("comment_id");
                String commentText = resultSet.getString("comment_text");
                String userName = resultSet.getString("user_name");
                long noteId = resultSet.getLong("note_id");

                comment = new Comment(commentId, commentText, userName, noteId);
                comments.add(comment.getCommentText());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not found");
        }
        return comments;
    }

}
