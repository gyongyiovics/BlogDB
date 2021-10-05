package application;

import application.database.DBEngine;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        DBEngine dbEngine = new DBEngine();
        //System.out.println(dbEngine.isConnected());
    }
}
