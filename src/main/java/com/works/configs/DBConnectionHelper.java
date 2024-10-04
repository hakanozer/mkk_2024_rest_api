package com.works.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBConnectionHelper {

    private String driver;
    private String url;
    private String username;
    private String password;

    private Connection conn = null;

    public void init(Properties appProps) throws Exception{
        driver = appProps.getProperty("database.driver");
        url = appProps.getProperty("database.url");
        username = appProps.getProperty("database.username");
        password = appProps.getProperty("database.password");
    }

    public Connection getConnection(){
        try {
            if (conn == null || conn.isClosed()) {
                Class.forName(driver);
                Connection conn = DriverManager.getConnection(url, username, password);
                return conn;
            }
        }catch (Exception ex) {
            System.err.println("getConnection errro : " + ex.getMessage());
        }
        return conn;
    }

    public void closeConnection(){
        try{
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        }catch(Exception e){
            System.err.println("closeConnection errro : " + e.getMessage());
        }
    }

}
