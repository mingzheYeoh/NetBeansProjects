/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.entity.User;
import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import java.util.Objects;
/**
 *
 * @author mingzhe
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try{
            String name=Objects.requireNonNull(req.getParameter("fname"));
            String email=Objects.requireNonNull(req.getParameter("email"));
            String phno=Objects.requireNonNull(req.getParameter("phno"));
            String password=Objects.requireNonNull(req.getParameter("password"));
            String check=req.getParameter("check");
            
            System.out.println(name+" "+email+" "+phno+" "+password+" "+check);
            
            User us = new User();
            us.setName(name);
            us.setEmail(email);
            us.setPhone(phno);
            us.setPassword(password);
            
            HttpSession session=req.getSession();
    
            if(check != null){
                
                UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
                boolean f = dao.userRegister(us);
                
                if(f){
                //System.out.println("User Register Successfully.");
                session.setAttribute("succMsg", "User Register Successfully.");
                resp.sendRedirect("registration.jsp");
                }else{
                    //System.out.println("Failed to register.");
                    session.setAttribute("failedMsg", "Failed to register, duplicate email.");
                    resp.sendRedirect("registration.jsp");
                }
            }else{
            
                session.setAttribute("failedMsg", "Please check the T & C");
                resp.sendRedirect("registration.jsp");
            }
            

   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    
}
