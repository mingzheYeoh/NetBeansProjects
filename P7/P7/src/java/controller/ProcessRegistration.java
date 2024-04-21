/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.RegisteredSubject;
import entity.Registration;
import entity.Student;
import entity.Subject;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.UserTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ProcessRegistration extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Student student = (Student) session.getAttribute("student");
            List<Subject> subjectList = (List<Subject>) session.getAttribute("subjectList");
            
            List<RegisteredSubject> selectedSubjectList = new ArrayList<RegisteredSubject>();
            for(int i = 0; i < subjectList.size(); i++){
                if(request.getParameter("subjectArr[" + i + "]") != null){
                    selectedSubjectList.add(new RegisteredSubject(subjectList.get(i)));
                    System.out.println(subjectList.get(i));
                }                
            }
            
            utx.begin();
            Registration registration = new Registration(student, selectedSubjectList);
            for(int i = 0; i < selectedSubjectList.size(); i++){
                selectedSubjectList.get(i).setRegId(registration);
            }
            em.persist(registration);
            utx.commit();
            
            session.setAttribute("registration", registration);
            response.sendRedirect("ConfirmRegistration.jsp");
            
        } catch (Exception ex) {

        }

    }

}
