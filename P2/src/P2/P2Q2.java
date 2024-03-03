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
public class P2Q2 extends JFrame{
    private JLabel color = new JLabel("COLOR");
    private JButton JbtnBlue = new JButton("BLUE");
    private JButton JbtnRed = new JButton("RED");
    private JButton JbtnGreen = new JButton("GREEN");
    
    public P2Q2(){
        color.setFont(new Font("Cambria", Font.BOLD, 20));
        color.setHorizontalAlignment(JLabel.CENTER);
        add(color, BorderLayout.NORTH);

        JbtnBlue.addActionListener(new ButtonListener());
        JbtnRed.addActionListener(new ButtonListener());
        JbtnGreen.addActionListener(new ButtonListener());
        
        JPanel jp = new JPanel();
        jp.add(JbtnBlue);
        jp.add(JbtnRed);
        jp.add(JbtnGreen);
        add(jp);
       
        setTitle("Primary Colors");
        setSize(300, 100);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==JbtnBlue){
                color.setForeground(Color.BLUE);
            }else if(e.getSource()==JbtnGreen){
                color.setForeground(Color.GREEN);
            }else if(e.getSource()==JbtnRed){
                color.setForeground(Color.red);
            }
        }
        
    }
    public static void main(String[] args) {
        new P2Q2();
    }
    
}

