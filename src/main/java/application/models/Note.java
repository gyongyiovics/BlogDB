package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

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

    private void getComments(Comment comment) {
        System.out.println("return a list of comments on note");
    }
}
