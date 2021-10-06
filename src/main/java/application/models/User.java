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
public class User {
    @Getter
    private int id;
    @Getter
    private String userName;
    @Getter
    private String passWord;
    @Getter
    private boolean isRegistered;
/*
    public User(int id, String userName, String passWord, boolean isRegistered) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.isRegistered = isRegistered;
    }*/

    //connection --> user & role
    private void getRole(RoleName roleName) {
        System.out.println("Connect user to role");
    }

    public List<Note> getNotes() {
        System.out.println("return a list of notes of user");
        return null;
    }
    //TODO: put this into a map as key: userName, value: List of Notes
    //return List<Note> notes

    private void getComments(List<Comment> comments) {
        System.out.println("return a list of comments of user");
    }
}
