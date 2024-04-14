package Paper_20230601;

import javax.swing.JOptionPane;

/**
 *
 * @author mingzhe
 */
public class DisplayStudentName {
    
    public static void main(String[] args) {
        String[] students = {"Clark Kent", "Natalie Teeger", "Adrian Monk", "Kevin Rudd"};
        
        try{
            String input = JOptionPane.showInputDialog("Enter index[1.." + students.length + "]");
            int index = Integer.parseInt(input) - 1;
            
            if (index < 0 | index > students.length){
                throw new IndexOutOfBoundsException();
            }
            JOptionPane.showMessageDialog(null, "Student#" + input + ":" + students[index]);
       
        }catch (IndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Array Index Out of Bound", "ERROR", JOptionPane.ERROR_MESSAGE);
        
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Incorrect input: an integer is required.", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
