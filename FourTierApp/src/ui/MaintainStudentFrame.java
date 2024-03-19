package ui;

import control.*;
import domain.Programme;
import domain.Student;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author mingzhe
 */
public class MaintainStudentFrame extends JFrame{
    private MaintainStudentControl studControl;
    private MaintainProgrammeControl progControl;
    
    private JTextField jtfID = new JTextField();
    private JTextField jtfIC = new JTextField();
    private JTextField jtfName = new JTextField();
    private JTextField jtfLevel = new JTextField();
    private JTextField jtfProgCode = new JTextField();
    private JTextField jtfYear = new JTextField();
    
    private JButton jbtAdd = new JButton("Create");
    private JButton jbtRetrieve = new JButton("Retrieve");
    private JButton jbtUpdate = new JButton("Update");
    private JButton jbtDelete = new JButton("Delete");

    public MaintainStudentFrame() {

        progControl = new MaintainProgrammeControl();
        studControl = new MaintainStudentControl();
        
        JPanel jpCenter = new JPanel(new GridLayout(6, 2));
        jpCenter.add(new JLabel("Student ID"));
        jpCenter.add(jtfID);
        jpCenter.add(new JLabel("Student IC"));
        jpCenter.add(jtfIC);
        jpCenter.add(new JLabel("Student Name"));
        jpCenter.add(jtfName);
        jpCenter.add(new JLabel("Level"));
        jpCenter.add(jtfLevel);
        jpCenter.add(new JLabel("Programme Code"));
        jpCenter.add(jtfProgCode);
        jpCenter.add(new JLabel("Year"));
        jpCenter.add(jtfYear);
        add(jpCenter);

        JPanel jpSouth = new JPanel();
        jpSouth.add(jbtAdd);
        jpSouth.add(jbtRetrieve);
        jpSouth.add(jbtUpdate);
        jpSouth.add(jbtDelete);
        add(jpSouth, BorderLayout.SOUTH);

        jbtAdd.addActionListener(new AddListener());
        jbtRetrieve.addActionListener(new RetrieveListener());
        jbtUpdate.addActionListener(new UpdateListener());
        jbtDelete.addActionListener(new DeleteListener());

        setTitle("Student CRUD");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    
    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfID.getText();
            Student s = studControl.selectRecord(id);
            
            if(s != null){
                JOptionPane.showMessageDialog(null, "This student already exists.", "DUPLICATE RECORD", JOptionPane.ERROR_MESSAGE);
            }else{
                Programme p = progControl.selectRecord(jtfProgCode.getText());
                s = new Student(id, jtfIC.getText(), jtfName.getText(), jtfLevel.getText().charAt(0),p, Integer.parseInt(jtfYear.getText()));
                studControl.addRecord(s);
                JOptionPane.showMessageDialog(null, "New Student added.");
                clearText();
            }
        }
    }

    private class RetrieveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfID.getText();
            Student s = studControl.selectRecord(id);
            
            if(s != null){
                jtfIC.setText(s.getIc());
                jtfName.setText(getName());
                jtfLevel.setText(s.getLevel() + "");
                jtfProgCode.setText(s.getProgramme().getCode());
                jtfYear.setText(s.getYear() + "");
            }else{
                JOptionPane.showMessageDialog(null, "No such student id.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }

    private class UpdateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfID.getText();
            Student s = studControl.selectRecord(id);
            
            if(s!= null){
                s.setIc(jtfIC.getText());
                s.setName(jtfName.getText());
                s.setLevel(jtfLevel.getText().charAt(0));
                Programme p = progControl.selectRecord(jtfProgCode.getText());
                s.setProgramme(p);
                s.setYear(Integer.parseInt(jtfYear.getText()));
                
                studControl.updateRecord(s);
                JOptionPane.showMessageDialog(null, "Record updated");
                clearText();
            }else{
                JOptionPane.showMessageDialog(null, "No such student id.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class DeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String id = jtfID.getText();
            Student s = studControl.selectRecord(id);
            
            if(s != null){
                jtfIC.setText(s.getIc());
                jtfName.setText(s.getName());
                jtfLevel.setText(s.getLevel() + "");
                jtfProgCode.setText(s.getProgramme().getCode());
                jtfYear.setText(s.getYear() + "");
                
                int option = JOptionPane.showConfirmDialog(null, "Are you sure? ");
                
                if(option == JOptionPane.YES_OPTION){
                    studControl.deleteRecord(s);
                    JOptionPane.showMessageDialog(null, "Record deleted.");
                    clearText();
                }
            }else{
                JOptionPane.showMessageDialog(null, "No such studen id.", "RECORD NOT FOUND", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void clearText(){
        jtfID.setText("");
        jtfIC.setText("");
        jtfName.setText("");
        jtfLevel.setText("");
        jtfProgCode.setText("");
        jtfYear.setText("");
        jtfID.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new MaintainStudentFrame();
    }

}
