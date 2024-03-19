/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import da.ProgrammeDA;
import domain.Programme;

public class MaintainProgrammeControl {
    
    private ProgrammeDA progDA;
    
    public MaintainProgrammeControl(){
        progDA = new ProgrammeDA();
    }
    
    public Programme selectRecord(String code){
        return progDA.getRecord(code);
    }
    
    public void addRecord(Programme programme){
        progDA.addRecord(programme);
    }
    
    public void updateRecord(Programme programme){
        progDA.updateRecord(programme);
    }
    
    public void deleteRecord(Programme programme){
        progDA.deleteRecord(programme);
    }
}
