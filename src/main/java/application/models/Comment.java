package application.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Comment {
    private int commentId;
    private String commentTitle;
    private String commentText;
    private String userName;
    private int noteId;

    //TODO: can add logic to noteId
    public int getCommentId() {
        return commentId;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public String getCommentText() {
        return commentText;
    }

    public String getUserName() {
        return userName;
    }

    public int getNoteId() {
        return noteId;
    }
}
