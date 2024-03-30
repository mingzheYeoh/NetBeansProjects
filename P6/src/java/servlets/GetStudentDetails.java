/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author xuanx
 */
public class GetStudentDetails extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String ic = request.getParameter("ic");
        String name = request.getParameter("name");
        char level = request.getParameter("level").charAt(0);
        String progCode = request.getParameter("progCode");
        int year = Integer.parseInt(request.getParameter("yr"));

        out.println("Student ID: <b> " + id + "</b><br>");
        out.println("IC Number: <b> " + ic + "</b><br>");
        out.println("Name: <b> " + name + "</b><br>");
        out.println("Level ID: <b> " + level + "</b><br>");
        out.println("Programme code: <b> " + progCode + "</b><br>");
        out.println("Year of Study: <b> " + year + "</b><br>");
        out.close();

    }
}
