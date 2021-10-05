package application.models;

public class Note {
    private String noteTitle;
    private String noteText;
    private String userName;
    private boolean hasComment;
    private State state;
    private String blogSchema; //or ENUM?

    private void getComments(Comment comment) {
        System.out.println("return a list of comments on note");
    }
}
