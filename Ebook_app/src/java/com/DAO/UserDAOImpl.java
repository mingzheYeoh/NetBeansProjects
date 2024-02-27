/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import java.sql.*;
import com.entity.User;
/**
 *
 * @author mingzhe
 */
public class UserDAOImpl implements UserDAO{
    
    private Connection conn;
    
    public UserDAOImpl(Connection conn){
        super();
        this.conn = conn;
    }
    
    @Override
    public boolean userRegister(User us){
        
        boolean f = false;
        
        try{
            if(!isEmailExists(us.getEmail())){
                
                String sql="insert into auth_user(name, email, phone_no, password) values(?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, us.getName());
                ps.setString(2, us.getEmail());
                ps.setString(3, us.getPhone());
                ps.setString(4, us.getPassword());



                int isUpdate = ps.executeUpdate();
                if (isUpdate > 0){
                    f=true;
                    System.out.println("Successfully update the data.");
                }else if(isUpdate == 0){
                    System.out.println("No match data.");
                }else{
                    System.out.println("Failed to update data.");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            
        return f;
    }

    @Override
    public User login(String email, String password) {
       
        User us = null;
        
        try{
            String sql="select * from auth_user where email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                us = new User();
                us.setId(rs.getInt(1));
                us.setName(rs.getString(2));
                us.setEmail(rs.getString(3));
                us.setPhone(rs.getString(4));
                us.setPassword(rs.getString(5));
                us.setAddress(rs.getString(6));
                us.setLandmark(rs.getString(7));
                us.setCity(rs.getString(8));
                us.setState(rs.getString(9));
                us.setPincode(rs.getString(10));
                
            }
            
        }catch(Exception e){  
            e.printStackTrace();
        }
        
        return us;

    }
    
    
    
    private boolean isEmailExists(String email) throws SQLException {
    String query = "SELECT COUNT(*) FROM auth_user WHERE email = ?";
    try (PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, email);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        }
    }
    return false;
}
}
