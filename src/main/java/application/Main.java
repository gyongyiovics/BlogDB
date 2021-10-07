package application;

import application.database.DBEngine;
import application.database.Query;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        DBEngine dbEngine = new DBEngine();
        //System.out.println(dbEngine.isConnected());

        Query query = new Query();

        //System.out.println(query.userList("user_role", "'USER'").get(0).getUserName());
        //System.out.println(query.userList("user_name", "'Gizi@123'").get(0).getUsersRole());
        //System.out.println(query.noteTexts("user_name", "'Jancsi@45'"));
        //System.out.println(query.noteTexts("blog_id", "1")); //--> not found
        System.out.println(query.commentTexts("note_id", "1")); //--> not found
    }
}
