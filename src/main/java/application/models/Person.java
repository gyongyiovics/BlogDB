package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Getter
    private String name;
    @Getter
    private boolean isRegistered;
    @Getter
    private List<Note> ownNotes;
    @Getter
    private List<Comment> ownComments;
    @Getter
    private List<Note> otherNotes;
    @Getter
    private List<Comment> otherComments;

    //TODO: what he/she can see
}
