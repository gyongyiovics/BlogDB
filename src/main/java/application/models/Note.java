package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Getter
    private long id;
    @Getter
    private String noteText;
    @Getter
    private String userName;
    @Getter
    private boolean hasComment;
    @Getter
    private String state;
    @Getter
    private long blogId;

}
