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
public class StudentInfoFrame extends JFrame{
    
    public StudentInfoFrame() {

    add(new JLabel("Registration Number"));
    add(new JTextField(10));

    add(new JLabel("Name"));
    add(new JTextField(20));

add(new JLabel("Programe Code"));
    add(new JTextField(10));

    add(new JButton("Submit"));

    setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

    setTitle("Student Information");

    setSize(500, 550);

    setLocationRelativeTo(null);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setVisible(true);

    }

    public static void main(String[] args) {
        new StudentInfoFrame();
    }
}
