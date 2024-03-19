package control;

import da.ProgrammeDA;
import da.StudentDA;
import domain.Programme;
import domain.Student;
/**
 *
 * @author mingzhe
 */
public class MaintainStudentControl {
    private StudentDA studDA;
    private ProgrammeDA progDA;
    
    public MaintainStudentControl(){
        studDA = new StudentDA();
    }
    
    public Student selectRecord(String code){
        return studDA.getRecord(code);
    }
    
    public void addRecord(Student student){
        studDA.addRecord(student);
    }
    
    public void updateRecord(Student student){
        studDA.updateRecord(student);
    }
    
    public void deleteRecord(Student student){
        studDA.deleteRecord(student);
    }    

}
