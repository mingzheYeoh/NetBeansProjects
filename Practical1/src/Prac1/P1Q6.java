/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prac1;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author mingzhe
 */
public class P1Q6 extends JFrame{
    
    public P1Q6(){
        setLayout(new BorderLayout());
        
        JPanel p1 = new JPanel(new GridLayout(1, 2));
        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        
        JPanel p2 = new JPanel(new GridLayout(1, 2));
        p2.add(new JButton("Button 3"));
        p2.add(new JButton("Button 4"));
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        //SET FRAME PROPERTIES
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new P1Q6();
    }
}
