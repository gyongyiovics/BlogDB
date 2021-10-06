package application.module;

import application.models.Comment;
import application.models.Note;
import application.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetDataFromSomewhere {
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
}
