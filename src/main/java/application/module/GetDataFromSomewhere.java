package application.module;

import application.models.*;
import lombok.Getter;

import java.util.ArrayList;
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
 * java: new Blog -> getText
 * visszaadja egy adott blogbejegyzéshez tartozó összes kommentet
 * mysql: SELECT comment_text FROM ... WHERE blog_text IS ...;
 * java: getNoteComments
 **/

public class GetDataFromSomewhere {


    public static void main(String[] args) {


    }

    @Getter
    public static List<User> userList = new ArrayList<>();
    @Getter
    List<Note> noteList = new ArrayList<>();
    @Getter
    List<Comment> commentList = new ArrayList<>();


    public static List<User> setUserList() {
        userList.add(new User(1, "Jancsi@45", "pw", RoleName.ADMIN));
        userList.add(new User(2, "Bela@bbb", "pw", RoleName.USER)); //NOT_REGISTERED_USER?
        userList.add(new User(3, "Gizi@123", "pw", RoleName.MODERATOR));
        userList.add(new User(4, "Geodesia23", "pw", RoleName.USER));
        return userList;
    }

    public List<Note> setNoteList() {
        noteList.add(new Note("Note1", "Hello world", "Jancsi@45", true, State.RELEASED, "blooming"));
        noteList.add(new Note("Note2", "Today's schedule", "Bela@bbb", true, State.DRAFT, "zombified"));
        noteList.add(new Note("Note3", "Zombie ipsum reversus ab viral inferno", "Geodesia23@45", false, State.DRAFT, "cats"));
        noteList.add(new Note("Note4", "Cum horribilem walking dead resurgere de crazed sepulcris creaturis...", "Gizi@123", true, State.DELETED, "zombified"));
        return noteList;
    }

    public List<Comment> setCommentList() {
        commentList.add(new Comment(1, "Comment1", "no comment", "Jancsi@45", "Note1"));
        commentList.add(new Comment(2, "Comment2", "hello again", "Jancsi@45", "Note1"));
        commentList.add(new Comment(3, "Comment3", "not today", "Jancsi@45", "Note2"));
        commentList.add(new Comment(4, "Comment4", "", "Jancsi@45", "Note4"));
        return commentList;
    }


    //TODO: debug: lists all of the users
    /*public static Map<String, List<User>> getUsersData (String roleName) {
        List <User> users = setUserList();
        Map<String, List<User>> userWithRole = new HashMap<>();

        for (User user : users) {
            if (user.getUsersRole().ROLE_NAME.equals(roleName)) {
                userWithRole.put(roleName, users);
                return userWithRole;
            }
        }
        return null;
    }*/

    //put into a map as key: userName, value: List of Notes
    private Map<User, List<Note>> getUserNotes(String userName) {
        Map<User, List<Note>> getNotesByUser = new HashMap<>();
        User user = new User();
        List<Note> noteList = user.getOwnNotes();

        if(userName.equals(user.getUserName())) {
            getNotesByUser.put(user, noteList);
            return getNotesByUser;
        }
        return null;
    }

    private Map<User, List<Comment>> getUserComments(String userName) {
        Map<User, List<Comment>> getCommentsByUser = new HashMap<>();
        User user = new User();
        List<Comment> commentList = user.getOwnComments();

        if(userName.equals(user.getUserName())) {
            getCommentsByUser.put(user, commentList);
            return getCommentsByUser;
        }
        return null;
    }

    private Map<String, List<Comment>> getNoteComments(String noteTitle) {
        Map<String, List<Comment>> getCommentsByNote = new HashMap<>();
        Note note = new Note();
        List<Comment> comments = note.getComments();

        if(note.isHasComment() && noteTitle.equals(note.getNoteTitle())) {
            getCommentsByNote.put(note.getNoteTitle(), comments);
            return getCommentsByNote;
        }
        return null;
    }
}
