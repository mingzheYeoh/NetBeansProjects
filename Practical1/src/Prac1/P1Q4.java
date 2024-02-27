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
public class P1Q4 extends JFrame{
    
    private JLabel regNumberLabel, nameLabel, programCodeLabel;
    private JTextField regNumberTextField, nameTextField, programCodeTextField;
    private JButton submitButton;

    public P1Q4() {
        
        add(new JLabel("Registration Number"));
        add(new JTextField(10));

        add(new JLabel("Name"));
        add(new JTextField(20));

        add(new JLabel("Programe Code"));
        add(new JTextField(10));

        add(new JButton("Submit"));

        setLayout(new GridLayout(10, 20));

        setTitle("Student Information");

        setSize(500, 550);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of StudentInfoFrame
        new P1Q4();
    }
}
