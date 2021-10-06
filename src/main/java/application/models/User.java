package application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * replica of the data in user_table in mysql
 */

@NoArgsConstructor
@AllArgsConstructor
public class User extends Person {
    @Getter
    private int id;
    @Getter
    private String userName;
    @Getter
    private String passWord;

    //connection --> user & role
    private void getRole(RoleName roleName) {
        System.out.println("Connect user to role");
    }

    //connection --> user & authorities

    public List<Note> getNotes() {
        System.out.println("return a list of notes of user");
        return null;
    }

    private List<Comment> getComments(List<Comment> comments) {
        System.out.println("return a list of comments of user");
        return null;
    }
}
