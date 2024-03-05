package chapter3_lecture;

import javax.swing.*;
/**
 *
 * @author mingzhe
 * The program will throw a java.lang.NumberFormatException if a non-integer is entered.
 */
public class ExceptionDemo {
    
    public static void main(String[] args) {
       
        try{
            String inputTxt = JOptionPane.showInputDialog("Enter an integer");
            int number = Integer.parseInt(inputTxt);
            JOptionPane.showMessageDialog(null, "The number entered is "+number);
            
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Incorrect input: an integer is required.", "Invalid input", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
