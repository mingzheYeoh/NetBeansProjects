package Paper_20220513;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mingzhe
 */
public class Q1c extends JFrame{
    
    private JFrame f = new JFrame("Staff Registration");
    private JPanel p1 = new JPanel();
    
    private JLabel idLabel = new JLabel("Staff ID:");
    private JLabel nameLabel = new JLabel("Full Name:");
    private JLabel deptLabel = new JLabel("Accounting:");
    private JLabel emptyLabel = new JLabel("");
    
    private JTextField id_Field = new JTextField(10);
    private JTextField name_Field = new JTextField(10);
    private JTextField dept_Field = new JTextField(10);
    
    private JButton submitBtn = new JButton("Submit");
    
    public Q1c(){
         
        p1.setLayout(new GridLayout(4, 2));
        p1.add(idLabel);
        p1.add(id_Field);
        p1.add(nameLabel);
        p1.add(name_Field);
        p1.add(deptLabel);
        p1.add(dept_Field);
        p1.add(emptyLabel);
        p1.add(submitBtn);
       
        
        f.add(p1, BorderLayout.CENTER);
        
        f.setSize(300, 200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Q1c();
    }
    
}
