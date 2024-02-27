/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package net.codejava.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mingzhe
 */
public class DBConnection {

    public static void main(String[] args) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: SQL Server JDBC Driver not found.");
            e.printStackTrace();
            return;
        }

        String url = "jdbc:sqlserver://YeohMingZhe\\SQLEXPRESS:1433;databaseName=student;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "Sa!23";

        try {
            // 连接数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database.");

            // 执行查询
            String sqlQuery = "SELECT top 3 * FROM student_details";  // 此处可能有语法错误，需要根据实际表和字段进行修改
            try (PreparedStatement statement = conn.prepareStatement(sqlQuery)) {
                ResultSet resultSet = statement.executeQuery();

                // 处理查询结果
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int mark = resultSet.getInt("mark");
                    System.out.println("ID: " + id + ", Name: " + name + ", Mark: " + mark);
                }
                
                // 成功读取数据时输出成功信息
                System.out.printf("\n\n\n\n\n\n");
                System.out.println("Successfully read data from the database.");
            }

            conn.close();
        } catch (SQLException e) {
            // SQL 查询相关异常
            System.err.println("Error executing SQL query.");
            e.printStackTrace();
        } catch (Exception e) {
            // 连接数据库异常
            System.err.println("Error connecting to the database.");
            e.printStackTrace();
        }
    }
}
