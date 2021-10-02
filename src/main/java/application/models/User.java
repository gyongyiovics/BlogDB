package application.models;

/**
 * replica of the data in user_table in mysql
 */

public class User {
    private int id;
    private String userName;
    private boolean isRegistered;
    //private RoleName roleName;
    //private String note;
    //private String comment;

    //connection --> user & role
    private void getRole(RoleName roleName) {
        System.out.println("Connect user to role");
    }

    private void getNotes(Note note) {
        System.out.println("return a list of notes of user");
    }

    private void getComments(Comment comment) {
        System.out.println("return a list of comments of user");
    }
}
