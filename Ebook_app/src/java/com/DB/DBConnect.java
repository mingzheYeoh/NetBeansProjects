package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author mingzhe
 */
public class DBConnect {

    private static Connection conn;
    
    public static void main(String[] args) throws SQLException {
        
        getConn();
    }
    
    public static Connection getConn() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\YeohMingZhe\\SQLEXPRESS:1433;databaseName=Ebook_app;encrypt=true;trustServerCertificate=true", "sa", "Sa!23");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: SQL Server JDBC Driver not found.");
            e.printStackTrace();
        }
       
        return conn;
    }
}
