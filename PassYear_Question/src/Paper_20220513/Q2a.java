package Paper_20220513;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mingzhe
 */
public class Q2a extends JFrame{
    
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog(null, "What is your name?");
        
        JOptionPane.showMessageDialog(null, "Welcome," + name + ",to Java Programming!");
    }
}
