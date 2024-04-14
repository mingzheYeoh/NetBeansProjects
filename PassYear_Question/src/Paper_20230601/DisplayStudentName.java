package Paper_20230601;

import javax.swing.JOptionPane;

/**
 *
 * @author mingzhe
 */
public class DisplayStudentName {
    
    public static void main(String[] args) {
        String[] students = {"Clark Kent", "Natalie Teeger", "Adrian Monk", "Kevin Rudd"};
        
        String input = JOptionPane.showInputDialog("Enter index[1.." + students.length + "]");
        
        int index = Integer.parseInt(input) - 1;
        JOptionPane.showMessageDialog(null, "Student#" + input + ":" + students[index]);
    }
}
