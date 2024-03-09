/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author mingzhe
 */
public class EnterPasswordFrame extends JFrame{
    
        JPasswordField jpfPassword = new JPasswordField(15);
	JButton jbtSubmit = new JButton("Submit");
	JTextArea jtaMessage = new JTextArea(5, 30);
		
  public EnterPasswordFrame() {
  	JPanel jpCenter = new JPanel(new GridLayout(2, 2));
  	jpCenter.add(new JLabel("Enter your password"));
  	jpCenter.add(jpfPassword);
  	jpCenter.add(new JLabel());
  	jpCenter.add(jbtSubmit);
  	  	
  	add(jpCenter, BorderLayout.CENTER); 
  	add(jtaMessage, BorderLayout.SOUTH);
  	jtaMessage.setLineWrap(true);
  	jtaMessage.setWrapStyleWord(true);
  	jtaMessage.setEditable(false);
  	
  	jbtSubmit.addActionListener(new ButtonListener());
  	jpfPassword.addActionListener(new ButtonListener());
  }
  
  private class ButtonListener implements ActionListener {
  	
        @Override
        public void actionPerformed(ActionEvent e) {
            jtaMessage.setText("");
            String inpStr = new String(jpfPassword.getPassword());
            try{
                Password pw = new Password(inpStr);
                jtaMessage.setForeground(Color.BLUE);
                jtaMessage.setText("Congratulations! Your password is valid.");  
            }catch(InvalidPasswordException ex){
                jtaMessage.setForeground(Color.RED);
                jtaMessage.setText(ex.getMessage());
                jpfPassword.grabFocus();
            }
        }
  }
    
  public static void main(String[] args) {
  	EnterPasswordFrame frm = new EnterPasswordFrame();
  	frm.setTitle("Set Password");
  	frm.pack();
  	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	frm.setLocationRelativeTo(null);
  	frm.setVisible(true);
  }
    
            
}
