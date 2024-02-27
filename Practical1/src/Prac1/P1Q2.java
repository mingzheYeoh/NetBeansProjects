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
public class P1Q2 extends JFrame{
    private JButton jbtHello = new JButton("Hello");
    
    public P1Q2(){
        add(jbtHello);
        setTitle("One Frame");
        setSize(50, 60);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new P1Q2();
    }
}
