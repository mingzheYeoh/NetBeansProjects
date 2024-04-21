/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Student;
import entity.Subject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author User
 */
public class RetrieveDetails extends HttpServlet {
    @PersistenceContext
    EntityManager em; 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
           String ID = request.getParameter("ID");
           Student student = em.find(Student.class, ID);
           HttpSession session = request.getSession();
           session.setAttribute("student", student);
           
           Query query = em.createNamedQuery("Subject.findAll");
           List<Subject> subjectList = query.getResultList();
           session.setAttribute("subjectList", subjectList);
           response.sendRedirect("EnterSubject.jsp");
           
       }catch(Exception ex){
           
       }
    }



}
