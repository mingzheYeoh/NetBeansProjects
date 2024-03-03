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

public class P2Q3 extends JFrame{
    
    private JLabel color = new JLabel("COLOR");
    private JButton JbtnBlue = new JButton("BLUE");
    private JButton JbtnRed = new JButton("RED");
    private JButton JbtnGreen = new JButton("GREEN");
    
    public P2Q3(){
        color.setFont(new Font("Cambria", Font.BOLD, 20));
        color.setHorizontalAlignment(JLabel.CENTER);
        add(color, BorderLayout.NORTH);

        JPanel jp = new JPanel();
        jp.add(JbtnBlue);
        jp.add(JbtnRed);
        jp.add(JbtnGreen);
        add(jp);
        
        
        //Inner listener class
        JbtnGreen.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color.setForeground(Color.GREEN);
            }
        });
        JbtnBlue.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color.setForeground(Color.BLUE);
            }
        });
        JbtnRed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                color.setForeground(Color.RED);
            }
        });
                
    }
    
    public static void main(String[] args) {
        P2Q3 frame = new P2Q3();
        
        frame.setTitle("Primary Colors");
        frame.setSize(250, 100);
        frame.setLocation(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
