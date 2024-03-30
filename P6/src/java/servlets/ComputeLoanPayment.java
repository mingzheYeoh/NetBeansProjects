package servlets;

import domain.Loan;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author mingzhe
 */
public class ComputeLoanPayment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String amtStr = req.getParameter("amount");
        String rateStr = req.getParameter("rate");
        String durationStr = req.getParameter("duration");

        if (amtStr.length() == 0 || rateStr.length() == 0 || durationStr.length() == 0) {
            out.println("Require all infos");
        } else {
            double amt = Double.parseDouble(amtStr);
            double rate = Double.parseDouble(rateStr);
            int duration = Integer.parseInt(durationStr);

            Loan loan = new Loan(rate, duration, amt);
            
            //Get a session or create one if it does not exist
            HttpSession httpSession = req.getSession();
        
            httpSession.setAttribute("loan", loan);

            //Ask for information
            out.println("You entered the following data:");
            out.println("<p>Loan Amount: RM" + String.format("%.2f", amt) + "</p>");
            out.println("<br> Annual interest rate: " + String.format("%.2f", rate));
            out.println("<br> Number of years: " + duration);

            //Set the action for processing
            out.println("<p><form method=\"post\" action=\"ComputeLoanPayment\"></p>");
            out.println("<p><input type=\"submit\" value=\"Confirm\"></p>");
            out.println("</form>");
            out.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        //Obtain the session
        HttpSession httpSession = req.getSession();
        
        //Get the Loan from httpSession
        Loan loan = (Loan) (httpSession.getAttribute("loan"));
        
        out.println("Loan Amount: RM" + String.format("%.2f", loan.getLoanAmount()));
        out.println("<br> Annual interest rate: " + String.format("%.2f", loan.getAnnualInterestRate()));
        out.println("<br> Number of Years: " + loan.getNumberOfYears());
        out.println("<br> Monthly Payment: RM" + String.format("%.2f", loan.getMonthlyPayment()));
        out.println("<br> Total Payment: RM" + String.format("%.2f", loan.getTotalPayment()));
        out.close();
        
    }
    
    
}
