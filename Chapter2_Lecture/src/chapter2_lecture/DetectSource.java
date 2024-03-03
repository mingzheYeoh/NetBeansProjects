/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chapter2_lecture;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author mingzhe
 */
public class DetectSource extends JFrame{
    private JButton jbtOK = new JButton("OK");
    private JButton jbtCancel = new JButton("Cancel");
    
    public DetectSource(){
        setLayout(new FlowLayout());
        add(jbtOK);
        add(jbtCancel);
        
        jbtOK.addActionListener(new ButtonListenerClass());
        jbtCancel.addActionListener(new ButtonListenerClass());
    }
    
    private class ButtonListenerClass implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           if (e.getSource()== jbtOK){
               JOptionPane.showMessageDialog(null, "OK button clicked");
           }else if(e.getSource()== jbtCancel){
               JOptionPane.showMessageDialog(null, "Cancel button clicked");
           }
        }
    }
    
    public static void main(String[] args) {
        HandleEvent frame = new HandleEvent();
        frame.setTitle("Handle Event");
        frame.setSize(250, 100);
        frame.setLocation(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


