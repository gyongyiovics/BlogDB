package application;

import application.database.DBEngine;
import application.database.Query;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        DBEngine dbEngine = new DBEngine();
        System.out.println(dbEngine.isConnected());

        Query query = new Query();

        System.out.println(query.userListByRole("'USER'").get(0).getUserName());
        System.out.println(query.userListByName("'Gizi@123'").get(0).getUsersRole());
        System.out.println(query.noteTextsById("blog_id", 1));
        System.out.println(query.blogsById("user_id", 1));
        System.out.println(query.commentTexts("1"));
    }
}
