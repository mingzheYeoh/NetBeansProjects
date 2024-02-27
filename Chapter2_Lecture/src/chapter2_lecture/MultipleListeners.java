package chapter2_lecture;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author mingzhe
 */
public class MultipleListeners extends JFrame{
    
    private JButton jbtOK = new JButton("OK");
    private JButton jbtCancel = new JButton("Cancel");
    
    private int countOKs = 0;
    private int countCancels = 0;
    
    public MultipleListeners(){
        setLayout(new FlowLayout());
        add(jbtOK);
        add(jbtCancel);
        
        jbtOK.addActionListener(new OKListenerClass());
        jbtCancel.addActionListener(new CancelListenerClass());
        
        CountListenerClass countListener = new CountListenerClass();
    }
    
    private class CountListenerClass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==jbtOK){
                countOKs++;
            }else{
                countCancels++;
            }
        }
        
    }
    
    private class OKListenerClass implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "OK button clicked total of " + countOKs + " times.");
        }
    }
    
    private class CancelListenerClass implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Cancel button clicked total of " + countCancels + " times.");
        }
    }
    
    public static void main(String[] args) {
        MultipleListeners frame = new MultipleListeners();
        
        frame.setTitle("MultipleListeners");
        frame.setSize(250, 100);
        frame.setLocation(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
