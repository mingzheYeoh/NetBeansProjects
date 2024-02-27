/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prac1;

import javax.swing.JOptionPane;

/**
 *
 * @author mingzhe
 */
public class P1Q1 {
    public static void main(String[] args) {
        int option = JOptionPane.YES_OPTION;
        
        do{
            String inputStr = JOptionPane.showInputDialog(null, "Enter a temp in F");
            double f = Double.parseDouble(inputStr);
            double celcius = 5.0/9.0*(f-32);
            JOptionPane.showMessageDialog(null, celcius);
            option = JOptionPane.showConfirmDialog(null, "Enter another temperature?");
            
        }while(option == JOptionPane.YES_NO_OPTION);
    }
}
