/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import java.util.ArrayList;
/**
 *
 * @author mingzhe
 */
public class P2Q4 extends JFrame{
    
    private ArrayList<String> studentList = new ArrayList<>();
    private JButton jbtCreate = new JButton("Create");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtDelete = new JButton("Delete");
    
    public P2Q4(){
        initializeStudents();
        setLayout(new FlowLayout());
        add(jbtCreate);
        add(jbtRetrieve);
        add(jbtUpdate);
        add(jbtDelete);
        
        ListStudentListener listStudentListener = new ListStudentListener();
        jbtCreate.addActionListener(listStudentListener);
        jbtUpdate.addActionListener(listStudentListener);
        jbtDelete.addActionListener(listStudentListener);
        
        
        jbtCreate.addActionListener(new CreateListener());
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtUpdate.addActionListener(new UpdateListener());
        jbtDelete.addActionListener(new DeleteListener());
        
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
 
    }
    
    private void initializeStudents(){
        studentList.add("Jack Ryan");
        studentList.add("Annette Hathaway");
        studentList.add("Marion Lee");
    }
    
    private class ListStudentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String list = "";
            for(int i = 0; i < studentList.size(); ++i){
                list += (i + 1) + ". " + studentList.get(i) + "\n";
            }
            JOptionPane.showMessageDialog(null, list, "Student List", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class CreateListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            String studentName = JOptionPane.showInputDialog("Enter new student's name: ");
            studentList.add(studentName);
        }
    }
     
    private class RetrieveListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            String noChoice = JOptionPane.showInputDialog("Enter the number from 1 to " + studentList.size() + " to retrieve the name");
            int index = Integer.parseInt(noChoice) - 1;
            JOptionPane.showMessageDialog(null, "Student Name: " + studentList.get(index), "Retrieve student name", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class UpdateListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            String noChoice = JOptionPane.showInputDialog("Enter the number from 1 to " + studentList.size() + " to update the name");
            int index = Integer.parseInt(noChoice) - 1;
            String updateName = JOptionPane.showInputDialog("Current name is " + studentList.get(index) + ". Enter the updated name: ");
            studentList.set(index, updateName);
            JOptionPane.showMessageDialog(null, "Student Name " + studentList.get(index) + " had been updated", "Update Student name", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private class DeleteListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            String noChoice = JOptionPane.showInputDialog("Enter the number from 1 to " + studentList.size() + " to delete the name");
            int index = Integer.parseInt(noChoice) - 1;
            int option = JOptionPane.showConfirmDialog(null, "Delete " + studentList.get(index));
            if (option == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Student Name " + studentList.get(index) + " had been deleted", "Delete Student name", JOptionPane.INFORMATION_MESSAGE);
                studentList.remove(index);
            }
        }
    }
    
    public static void main(String[] args) {
        new P2Q4();
    }
}
