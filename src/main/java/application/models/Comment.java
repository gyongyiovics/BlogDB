package application.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Comment {
    private long commentId;
    private String commentText;
    private String userName;
    private long noteId;

    public long getCommentId() {
        return commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public String getUserName() {
        return userName;
    }

    public long getNoteId() {
        return noteId;
    }
}
