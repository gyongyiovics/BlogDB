package application.module;

import application.models.Comment;
import application.models.Note;
import application.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * visszaadja adott szerepkörű felhasználók összes adatát
 * mysql: SELECT * FROM user WHERE role IS ...;
 * java: getUsersData
 * visszaadja egy adott felhasználó összes adatát:
 * mysql: SELECT * FROM user WHERE user_name IS ...;
 * java: new User
 * visszaadja egy adott felhasználó összes blogját
 * mysql: SELECT blog_text FROM ... WHERE user_name IS ...;
 * java: getUserNotes
 * visszaadja egy adott blog összes blogbejegyzését
 * mysql: SELECT blog_text FROM ... WHERE blog is ...;
 * java: new Blog
 * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
 * mysql: SELECT comment_text FROM ... WHERE blog_text IS ...;
 * java: getNoteComments
 **/

public class GetDataFromSomewhere {
    private Map<String, List<User>> getUsersData (String roleName) {
        return null;
    }

    //put into a map as key: userName, value: List of Notes
    private Map<User, List<Note>> getUserNotes(String userName) {
        Map<User, List<Note>> getNotesByUser = new HashMap<>();
        User user = new User();
        List<Note> noteList = user.getOwnNotes();

        if(userName.equals(user.getUserName()))
            getNotesByUser.put(user, noteList);

        return getNotesByUser;
    }

    private Map<User, List<Comment>> getUserComments(String userName) {
        Map<User, List<Comment>> getCommentsByUser = new HashMap<>();
        User user = new User();
        List<Comment> commentList = user.getOwnComments();

        if(userName.equals(user.getUserName()))
            getCommentsByUser.put(user, commentList);

        return getCommentsByUser;
    }

    private Map<String, List<Comment>> getNoteComments(String noteTitle) {
        return null;
    }
}
