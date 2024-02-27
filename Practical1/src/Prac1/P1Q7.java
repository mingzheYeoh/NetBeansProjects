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
public class P1Q7 extends JFrame{
    
    public P1Q7(){
        setLayout(new BorderLayout());
        
        CustomPanel p1 = new CustomPanel();
        CustomPanel p2 = new CustomPanel();
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new P1Q7();
    }
}

class CustomPanel extends JPanel{
    public CustomPanel(){
        setLayout(new GridLayout(1, 2));
        
        add(new Button("Button 1"));
        add(new Button("Button 2"));
        
    }
}

