package Paper_20230710;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
public class Q2a extends JFrame{
    
    private JFrame f = new JFrame("Search");
    
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    
    
    private JLabel Label1 = new JLabel("Key in your item code to search:");
    private JLabel codeLabel = new JLabel("Item Code:");
    private JLabel emptyLabel = new JLabel("");
    
    private JTextField jtf = new JTextField(10);
    
    private JButton search = new JButton("Search");
    
    public Q2a(){
        
        p1.add(Label1);
        
        p2.add(codeLabel);
        p2.add(jtf);
        p2.add(emptyLabel);
        p2.add(search);
        
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.setLayout(new GridLayout(2,2));
        
        f.add(p1, BorderLayout.CENTER);
        f.add(p2, BorderLayout.SOUTH);
        
        f.setSize(250, 100);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new Q2a();
    }
}
