/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prac1;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author mingzhe
 */
public class P1Q5 extends JFrame{
    
    public P1Q5(){
        
        super("Custom Frame");
        
        //Set Layout of the frame to FlowLayout
        setLayout(new FlowLayout());
        
        //Create first panel with two buttons
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        panel1.add(button1);
        panel1.add(button2);
        
        JPanel panel2 = new JPanel();
        panel1.setLayout(new FlowLayout());
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        panel1.add(button3);
        panel1.add(button4);
        
        add(panel1);
        add(panel2);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new P1Q5();
    }
 
}
