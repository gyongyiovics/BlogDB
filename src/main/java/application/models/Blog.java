package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Blog {
    @Getter
    private long id;
    @Getter
    private String noteText;
    @Getter
    private String commentText;
    @Getter
    private String blogSchema;

}
