package application.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Comment {
    private int commentId;
    private String commentTitle;
    private String commentText;
    private String userName;
    private String noteTitle;

    //TODO: add logic to getNoteTitle
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

    public String getNoteTitle() {
        return noteTitle;
    }
}
