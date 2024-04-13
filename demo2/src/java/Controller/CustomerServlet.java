package Controller;

import DAO.CustomerRegisterService;
import DB_Model.CustomerRegister;
import jakarta.annotation.Resource;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.transaction.UserTransaction;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.*;

public class CustomerServlet extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    @Resource
    UserTransaction utx;

    private CustomerRegisterService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerRegisterService(em);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String action = request.getParameter("action");
            if (action == null) {
                response.sendRedirect(request.getContextPath());
                return;
            }

            switch (action) {
                case "add":
                    addCustomer(request, response);
                    break;
                case "update":
                    updateCustomer(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                case "viewAll":
                    viewAllCustomers(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath());
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerServlet.class.getName()).log(Level.SEVERE, "An error occurs", ex);
        }
    }

    private void viewAllCustomers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<CustomerRegister> customers = customerService.findAllCustomers();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/viewAllCustomers.jsp").forward(request, response);
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LocalDate joinedDate = LocalDate.parse(request.getParameter("joinedDate"));

        CustomerRegister customer = new CustomerRegister();
        customer.setCustomerName(name);
        customer.setCustomerEmail(email);
        customer.setCustomerPassword(password);
        Date sqlJoinedDate = Date.valueOf(joinedDate);
        customer.setJoinedDate(sqlJoinedDate);

        try {
            utx.begin();
            if (customerService.addCustomer(customer)) {
                utx.commit();
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                utx.rollback();
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerServlet.class.getName()).log(Level.SEVERE, "An error occurs", ex);
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        LocalDate joinedDate = LocalDate.parse(request.getParameter("joinedDate"));

        CustomerRegister customer = new CustomerRegister();
        customer.setCustomerId(customerId);
        customer.setCustomerName(name);
        customer.setCustomerEmail(email);
        customer.setCustomerPassword(password);

        Date sqlJoinedDate = Date.valueOf(joinedDate);
        customer.setJoinedDate(sqlJoinedDate);

        try {
            utx.begin();
            if (customerService.updateCustomer(customer)) {
                utx.commit();
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                utx.rollback();
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerServlet.class.getName()).log(Level.SEVERE, "An error occurs", ex);
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        try {
            utx.begin();
            if (customerService.deleteCustomer(customerId)) {
                utx.commit();
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            } else {
                utx.rollback();
                response.sendRedirect(request.getContextPath() + "/error.jsp");
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerServlet.class.getName()).log(Level.SEVERE, "An error occurs", ex);
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Customer CRUD";
    }
}
