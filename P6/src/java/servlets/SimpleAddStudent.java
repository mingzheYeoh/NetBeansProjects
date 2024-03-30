package servlets;

import da.ProgrammeDA;
import da.StudentDA;
import domain.Programme;
import domain.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mingzhe
 */
public class SimpleAddStudent extends HttpServlet {

    private StudentDA studDA;
    private ProgrammeDA progDA;

    @Override
    public void init() throws ServletException {
        studDA = new StudentDA();
        progDA = new ProgrammeDA();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String id = request.getParameter("id");
        String ic = request.getParameter("ic");
        String name = request.getParameter("name");
        char level = request.getParameter("level").charAt(0);
        String progCode = request.getParameter("progCode");
        int year = Integer.parseInt(request.getParameter("yr"));
        
        try{
            Programme p = progDA.getRecord(progCode);
            Student s = new Student(id, ic, name, level, p, year);
            studDA.addRecord(s);
            out.println("Student <b>" + id + "</b> has been added to the database");
        }catch (Exception ex){
            out.println(ex.getMessage());
        }finally{
            out.close();
        }
    }

}
