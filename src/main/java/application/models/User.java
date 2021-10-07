package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * replica of the data in user_table in mysql
 */

@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {
    @Getter
    private long id;
    @Getter
    private String userName;
    @Getter
    private String passWord;
    @Getter
    private RoleName usersRole;


    public List<Note> getNotes(Note note) {
        System.out.println("return a list of notes of user");
        List<Note> noteList = new ArrayList<>();
        if(note.getUserName().equals(userName)) {
            noteList.add(note);
            return noteList;
        }
        return null;
    }

    private List<Comment> getComments(Comment comment) {
        System.out.println("return a list of comments of user");
        List<Comment> commentList = new ArrayList<>();
        if(comment.getUserName().equals(userName)) {
            commentList.add(comment);
            return commentList;
        }
        return null;
    }
}
