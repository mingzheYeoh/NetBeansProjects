package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mingzhe
 */
public class Q4Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id");
        String ic = request.getParameter("ic");
        String name = request.getParameter("name");
        char level = request.getParameter("level").charAt(0);
        String progCode = request.getParameter("progCode");
        int year = Integer.parseInt(request.getParameter("yr"));
        
        Cookie cookie = new Cookie("name", name);
        response.addCookie(cookie);
        
        try{
            out.println("Student ID: <b>" + id + "</b><br>");
            out.println("Student IC: <b>" + ic + "</b><br>");
            out.println("Name: <b>" + name + "</b><br>");
            out.println("Programme Code: <b>" + progCode + "</b><br>");
            out.println("Year of Study: <b>"+ year + "</b><br>");
            
            out.println("<a href='ThirdServlet'>Click here</a>");
        }catch (Exception ex){
            throw ex;
        }finally{
            out.close();
        }
    }

}
