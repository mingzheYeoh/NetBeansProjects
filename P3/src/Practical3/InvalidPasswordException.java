/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practical3;

/**
 *
 * @author mingzhe
 */
public class InvalidPasswordException extends Exception{
    
    public InvalidPasswordException(){
        super("Invalid Password Exception");
    }
    
    public InvalidPasswordException(String errMsg){
        super(errMsg);
    }
}
