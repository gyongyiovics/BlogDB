package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Getter
    private String noteTitle;
    @Getter
    private String noteText;
    @Getter
    private String userName;
    @Getter
    private boolean hasComment;
    @Getter
    private State state;
    @Getter
    private String blogSchema; //or ENUM?

    public List<Comment> getComments() {
        System.out.println("return a list of comments on note");
        List<Comment> commentList = new ArrayList<>();

        List<Comment> commentsOfNote = new ArrayList<>();

        for(Comment comment : commentList) {
            if(hasComment && (comment.getNoteTitle().equals(noteTitle))) {
                commentsOfNote.add(comment);
            }
        }

        return commentsOfNote;
    }
}
