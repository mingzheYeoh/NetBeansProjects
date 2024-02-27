/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;
/**
 *
 * @author mingzhe
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            UserDAOImpl dao = new UserDAOImpl(DBConnect.getConn());
            
            HttpSession session = req.getSession();
            String email=req.getParameter("email");
            String password=req.getParameter("password");
            
            if("admin@gmail.com".equals(email) && "admin".equals(password)){
                User us = new User();
                session.setAttribute("userObj", us);
                resp.sendRedirect("admin/home.jsp");
            }else{
                User us = dao.login(email, password);
                if(us != null){
                    session.setAttribute("userObj", us);
                    resp.sendRedirect("home.jsp");
                }else{
                    session.setAttribute("failedMsg", "Email & password Invalid");
                    resp.sendRedirect("login.jsp");
                }
                resp.sendRedirect("home.jsp");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
