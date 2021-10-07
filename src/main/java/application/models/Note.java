package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Note {
/*    @Getter
    private long id;*/
    @Getter
    private String noteText;
    @Getter
    private String userName;
    @Getter
    private boolean hasComment;
    @Getter
    private String state;
    @Getter
    private long blogId;

    /*public List<Comment> getComments() {
        System.out.println("return a list of comments on note");
        List<Comment> commentList = new ArrayList<>();

        List<Comment> commentsOfNote = new ArrayList<>();

        for(Comment comment : commentList) {
            if(hasComment && (comment.getNoteId() == id)) {
                commentsOfNote.add(comment);
            }
        }

        return commentsOfNote;
    }*/
}
