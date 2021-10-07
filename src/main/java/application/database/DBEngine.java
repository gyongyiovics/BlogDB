package application.database;

import java.sql.*;
import java.util.Properties;

public class DBEngine {
    private Connection connection;

    public DBEngine() {
        connection = connect();
    }
    public boolean isConnected(){
        return (connection != null);
    }

    public Connection connect() {
        String localhost = "jdbc:mysql://localhost:3306/";
        String dbName = "blogDB";
        String rest = "?useUnicode=yes&characterEncoding=UTF-8";
        String url = localhost + dbName + rest;
        Properties properties = new Properties();


        properties.put("user", System.getenv("DB_USER"));
        properties.put("password", System.getenv("DB_PASSWORD"));

        /*properties.put("user", "root");
        properties.put("password", "1981&Gyongyi");*/
        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}