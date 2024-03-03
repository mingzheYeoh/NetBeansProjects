/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
/**
 *
 * @author mingzhe
 */
public class P2Q1 extends JFrame{
    
    private JLabel color = new JLabel("COLOR");
    private JButton JbtnBlue = new JButton("BLUE");
    private JButton JbtnRed = new JButton("RED");
    private JButton JbtnGreen = new JButton("GREEN");
    
    public P2Q1(){
        color.setFont(new Font("Cambria", Font.BOLD, 20));
        color.setHorizontalAlignment(JLabel.CENTER);
        add(color, BorderLayout.NORTH);

        JPanel jp = new JPanel();

        jp.add(JbtnBlue);
        jp.add(JbtnRed);
        jp.add(JbtnGreen);
        add(jp); 
        
        JbtnBlue.addActionListener(new BlueButtonListener());
        JbtnRed.addActionListener(new RedButtonListener());
        JbtnGreen.addActionListener(new GreenButtonListener());
              
        setTitle("Primary Colors");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class RedButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            color.setForeground(Color.red);
        }
    }
    private class BlueButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            color.setForeground(Color.blue);
        }
    }
    private class GreenButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            color.setForeground(Color.green);
        }
    }
    
    public static void main(String[] args) {
        new P2Q1();
    }
}
