package DB;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author mingzhe
 */
public class DB_Connection {
    
    //Database Information
    private String hostURL = "jdbc:derby://localhost:1527/Abibas";
    private String username = "sa";
    private String password = "Sa!23";
    
    //Connection to database
    private Connection conn;
    private PreparedStatement ps;
    
    public DB_Connection(){
        createConnection();
    }
    
    private void createConnection() {
        try {
            conn = DriverManager.getConnection(hostURL, username, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        DB_Connection db_conn = new DB_Connection();
    }
}
