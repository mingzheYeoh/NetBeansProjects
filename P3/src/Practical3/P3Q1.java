package Practical3;

/**
 *
 * @author mingzhe
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class P3Q1 extends JFrame{
    
    private JLabel first_label = new JLabel("First Number");
    private JLabel second_label = new JLabel("Second Number");
    private JLabel result_label = new JLabel("Result");
    private JTextField first_text = new JTextField();
    private JTextField second_text = new JTextField();
    private JTextField result_text = new JTextField();
    private JButton add_button = new JButton("Add");
    private JButton substract_button = new JButton("Substract");
    private JButton multiply_button = new JButton("Multiply");
    private JButton divide_button = new JButton("Divide");
    
    
    public P3Q1(){
        setTitle("Simple Calculator");
        
        JPanel jpCenter = new JPanel(new GridLayout(3,2,2,2));
        jpCenter.add(first_label);
        
        jpCenter.add(first_text);
        jpCenter.add(second_label);
        jpCenter.add(second_text);
        jpCenter.add(result_label);
        jpCenter.add(result_text);
        add(jpCenter, BorderLayout.CENTER);
        
        JPanel jpSouth = new JPanel();
        jpSouth.add(add_button);
        jpSouth.add(substract_button);
        jpSouth.add(multiply_button);
        jpSouth.add(divide_button);
        add(jpSouth, BorderLayout.SOUTH);
        
        add_button.setMnemonic('A');
        substract_button.setMnemonic('S');
        multiply_button.setMnemonic('M');
        divide_button.setMnemonic('D');
        
        ButtonListener buttonListener = new ButtonListener();
        add_button.addActionListener(buttonListener);
        substract_button.addActionListener(buttonListener);
        multiply_button.addActionListener(buttonListener);
        divide_button.addActionListener(buttonListener);
        
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    private class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            try{
               double firstVal = Double.parseDouble(first_text.getText());
               double secondVal = Double.parseDouble(second_text.getText());
               double result = 0;

               if(e.getSource()==add_button){
                   result = firstVal + secondVal;
               }else if(e.getSource()==substract_button){
                   result = firstVal - secondVal;
               }else if(e.getSource()==multiply_button){
                   result = firstVal * secondVal;
               }else if(e.getSource()==divide_button){
                   result = firstVal / secondVal;
               }
               result_text.setText(result + "");
           }catch(NumberFormatException ex){
               JOptionPane.showInternalMessageDialog(null, "Non-numeric operands", "ERROR", JOptionPane.ERROR_MESSAGE);
               clearTextFields();
           }
        }
    }
    
    public void clearTextFields(){
        first_text.setText("");
        second_text.setText("");
        result_text.setText("");
        first_text.grabFocus();
    }
    
    public static void main(String[] args) {
        new P3Q1();
    }

}
