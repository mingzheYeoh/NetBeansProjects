/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mingzhe
 */
public class P3Q2 extends JFrame{
    private int[] intArr = new int[100];
    private JTextField jtfIndex = new JTextField();
    private JTextField jtfElement = new JTextField();
    private JButton jbtDisplay = new JButton("Show Element");
    
    public P3Q2(){
        initializeArray();
        JPanel jpCenter = new JPanel(new GridLayout(2, 3));
        jpCenter.add(new JLabel("Array Index"));
        jpCenter.add(jtfIndex);
        jpCenter.add(new JLabel("Array Element"));
        jpCenter.add(jtfElement);
        jtfElement.setEditable(false);
        add(jpCenter);
        
        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtDisplay);
        add(jpSouth, BorderLayout.SOUTH);
        
        jbtDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int index = Integer.parseInt(jtfIndex.getText());
                    jtfElement.setText("" + intArr[index]);
                }catch(ArrayIndexOutOfBoundsException ex){
                    jtfElement.setText("Out of Bound");
                }
            }
        });
        
        setTitle("Display: Show Bounds Error");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initializeArray(){
        for(int i=0; i<intArr.length; ++i){
            intArr[i] = (int) (Math.random() * 10000);
        }
    }
    
    public static void main(String[] args) {
        new P3Q2();
    }
    
}
