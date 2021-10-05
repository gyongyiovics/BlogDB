package application.models;

public class Blog {
    private int id;
    private String noteText; //make a List?
    private String commentText; //make a List?
    private boolean isOwn;
    private String blogSchema;

    public Blog(int id, String noteText, String commentText, boolean isOwn, String blogSchema) {
        this.id = id;
        this.noteText = noteText;
        this.commentText = commentText;
        this.isOwn = isOwn;
        this.blogSchema = blogSchema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public boolean isOwn() {
        return isOwn;
    }

    public void setOwn(boolean own) {
        isOwn = own;
    }

    public String getBlogSchema() {
        return blogSchema;
    }

    public void setBlogSchema(String blogSchema) {
        this.blogSchema = blogSchema;
    }
}
