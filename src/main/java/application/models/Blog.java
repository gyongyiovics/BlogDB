package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Blog {
    @Getter
    private int id;
    @Getter
    private List<String> noteText; //make a List?
    @Getter
    private List<String> commentText; //make a List?
    @Getter
    private boolean isOwn;
    @Getter
    private String blogSchema;

}
