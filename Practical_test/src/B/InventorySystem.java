package B;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author mingzhe
 */
public class InventorySystem extends JFrame {

    private JFrame f = new JFrame();

    private JPanel p1 = new JPanel(new GridLayout(4, 4));
    private JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JLabel product_id_label = new JLabel("Product ID");
    private JLabel description_label = new JLabel("Description");
    private JLabel price_label = new JLabel("Price");
    private JLabel quantity_label = new JLabel("Quantity On Hand");

    private JLabel emptyLabel1 = new JLabel("");
    private JLabel emptyLabel2 = new JLabel("");
    private JLabel emptyLabel3 = new JLabel("");

    private JTextField id_field = new JTextField(10);
    private JTextField description_field = new JTextField(10);
    private JTextField price_field = new JTextField(10);
    private JTextField quantity_field = new JTextField(10);

    private JButton SearchButton = new JButton("Search");
    private JButton AddButton = new JButton("Add new Product");
    private JButton StockOutButton = new JButton("Stock Out");
    private JButton StockInButton = new JButton("Stock in");

    //Database information
    private String url = "jdbc:derby://localhost:1527/ShopDB";
    private String username = "nbuser";
    private String password = "nbuser";

    //Connection
    private Connection conn;

    public InventorySystem() {

        //Connect to the database
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }

        //frame attributes
        f.setTitle("Inventory System");
        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.SOUTH);

        //add the label, text field to panel1
        p1.add(product_id_label);
        p1.add(id_field);
        p1.add(description_label);
        p1.add(description_field);
        p1.add(price_label);
        p1.add(price_field);
        p1.add(quantity_label);
        p1.add(quantity_field);

        //add the button to panel1
        p2.add(SearchButton);
        p2.add(AddButton);
        p2.add(StockOutButton);
        p2.add(StockInButton);

        SearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productID = id_field.getText();
                String oldProductDescription;
                try {
                    // Prepare a PreparedStatement to prevent SQL injection
                    String sql = "SELECT * FROM NBUSER.PRODUCT WHERE PRODUCTID = ?";
                    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                        pstmt.setString(1, productID); // Set the productID as a parameter
                        ResultSet rsProductID = pstmt.executeQuery();
                        // Check if the productID exists
                        if (rsProductID.next()) {
                            String oldProductID = rsProductID.getString("PRODUCTID");
                            oldProductDescription = rsProductID.getString("DESCRIPTION");
                            JOptionPane.showMessageDialog(null, "Product ID Found: " + oldProductID + '\n'
                                    + "Product Description :" + oldProductDescription,
                                    "Message", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No such product id: " + productID, "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
                        }
                        pstmt.close();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error executing SQL query: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Add button
        AddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productID = id_field.getText();
                String description = description_field.getText();
                String price = price_field.getText();
                String quantity = quantity_field.getText();

                double formatted_price = Double.parseDouble(price);
                int formatted_quantity = Integer.parseInt(quantity);

                try {
                    // Check if the productID already exists
                    String checkQuery = "SELECT PRODUCTID FROM NBUSER.PRODUCT WHERE PRODUCTID = ?";
                    try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                        checkStmt.setString(1, productID);
                        ResultSet rs = checkStmt.executeQuery();

                        // If the productID already exists, show error message
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "Product ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // If the productID does not exist, proceed with insertion
                            String insertQuery = "INSERT INTO NBUSER.PRODUCT VALUES(?, ?, ?, ?)";
                            try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                                insertStmt.setString(1, productID);
                                insertStmt.setString(2, description);
                                insertStmt.setDouble(3, formatted_price);
                                insertStmt.setInt(4, formatted_quantity);
                                insertStmt.executeUpdate();

                                JOptionPane.showMessageDialog(null, "Product added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        checkStmt.close();
                    }
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error executing SQL query: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Stock out button
        StockOutButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String productID = id_field.getText();
                
                 try {
                    // Check if the productID already exists
                    String checkQuery = "SELECT PRODUCTID, QUANTITYONHAND FROM NBUSER.PRODUCT WHERE PRODUCTID = ?";
                    try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                        checkStmt.setString(1, productID);
                        ResultSet rs = checkStmt.executeQuery();

                        // If the productID already exists, show error message
                        if (rs.next()) {
                            String oldStock_quantity = rs.getString("QUANTITYONHAND");
                            String stockOut_quantity = JOptionPane.showInputDialog(null, "Enter Stock Out quantity", "Input", JOptionPane.QUESTION_MESSAGE);
                            
                            int format_old_quantity = Integer.parseInt(oldStock_quantity);
                            int input_old_quantity = Integer.parseInt(stockOut_quantity);
                            
                            if(input_old_quantity > format_old_quantity){
                                JOptionPane.showMessageDialog(null, "The input quantity is exceed the stock quantity", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }else{
                                int newStock_quantity = format_old_quantity - input_old_quantity;
                                
                                String insertQuery = "UPDATE NBUSER.PRODUCT SET QUANTITYONHAND = ? WHERE PRODUCTID = ?";
                                try(PreparedStatement insertStmt = conn.prepareStatement(insertQuery)){
                                    insertStmt.setString(1, Integer.toString(newStock_quantity));
                                    insertStmt.setString(2, productID);
                                    insertStmt.executeUpdate();
                                    
                                    insertStmt.close();
                                }
                                JOptionPane.showMessageDialog(null, "Quantity updated", "Message", JOptionPane.INFORMATION_MESSAGE);
                            }
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "No Product Found", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error executing SQL query: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }            
        });
        
        //Stock In button
        StockInButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String productID = id_field.getText();
                
                 try {
                    // Check if the productID already exists
                    String checkQuery = "SELECT PRODUCTID, QUANTITYONHAND FROM NBUSER.PRODUCT WHERE PRODUCTID = ?";
                    try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                        checkStmt.setString(1, productID);
                        ResultSet rs = checkStmt.executeQuery();

                        // If the productID already exists, show error message
                        if (rs.next()) {
                            String oldStock_quantity = rs.getString("QUANTITYONHAND");
                            String stockOut_quantity = JOptionPane.showInputDialog(null, "Enter Stock In quantity", "Input", JOptionPane.QUESTION_MESSAGE);
                            
                            int format_old_quantity = Integer.parseInt(oldStock_quantity);
                            int input_old_quantity = Integer.parseInt(stockOut_quantity);
                            int newStock_quantity = format_old_quantity + input_old_quantity;

                            String insertQuery = "UPDATE NBUSER.PRODUCT SET QUANTITYONHAND = ? WHERE PRODUCTID = ?";
                            try(PreparedStatement insertStmt = conn.prepareStatement(insertQuery)){
                                insertStmt.setString(1, Integer.toString(newStock_quantity));
                                insertStmt.setString(2, productID);
                                insertStmt.executeUpdate();

                                insertStmt.close();
                            }
                            JOptionPane.showMessageDialog(null, "Quantity updated", "Message", JOptionPane.INFORMATION_MESSAGE);
                            
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "No Product Found", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error executing SQL query: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }            
        });

        f.setLocationRelativeTo(null);
        f.setSize(420, 170);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new InventorySystem();
    }

}
