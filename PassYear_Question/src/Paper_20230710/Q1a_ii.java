package Paper_20230710;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Q1a_ii extends JFrame{
    
    public Q1a_ii(){
        
       JOptionPane.showConfirmDialog(null, "Are you sure want to continue", 
                                "Warning", JOptionPane.YES_NO_OPTION, 
                                JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void main(String[] args) {
        new Q1a_ii();
    }
}
