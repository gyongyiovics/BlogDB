package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Comment {
    @Getter
    private long commentId;
    @Getter
    private String commentText;
    @Getter
    private String userName;
    @Getter
    private long noteId;

}
