package Event_Handling;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mingzhe
 */
public class buttonListener extends JFrame {
    
   
    public buttonListener(){
        JButton OKbutton = new JButton("OK");
        
        //Register the listener with the button
        OKbutton.addActionListener(new OKButtonListener());
        
        JFrame frame = new JFrame();
        frame.add(OKbutton, BorderLayout.CENTER);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new buttonListener();
    }
    
    public class OKButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "This is OK button.");
        }
        
    }
}
