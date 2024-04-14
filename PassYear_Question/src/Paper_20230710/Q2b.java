package Paper_20230710;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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
public class Q2b {

    private String host = "jdbc:derby://localhost:1527/Item";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;

    private JFrame f = new JFrame("Search");

    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();

    private JLabel Label1 = new JLabel("Key in your item code to search:");
    private JLabel codeLabel = new JLabel("Item Code:");
    private JLabel emptyLabel = new JLabel("");

    private JTextField jtfItemCode = new JTextField(10);

    private JButton jbtSearch = new JButton("Search");

    public Q2b() {

        try {
            conn = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            ex.getMessage();
        }

        p1.add(Label1);

        p2.add(codeLabel);
        p2.add(jtfItemCode);
        p2.add(emptyLabel);
        p2.add(jbtSearch);

        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.setLayout(new GridLayout(2, 2));

        f.add(p1, BorderLayout.CENTER);
        f.add(p2, BorderLayout.SOUTH);

        jbtSearch.addActionListener(new ActionListener() {

            String sql = "select * from Item where item_code = ?";
           
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemCode = jtfItemCode.getText();
                try {
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, itemCode);

                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Record Found");
                    } else {
                        JOptionPane.showMessageDialog(null, "Record Not Found");
                    }

                } catch (SQLException ex) {
                    ex.getMessage();
                }
            }
        });

        f.setSize(250, 100);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Q2b();
    }
}
