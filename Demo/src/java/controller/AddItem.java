package controller;

import model.Item;
import model.ItemService;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.UserTransaction;
import java.util.logging.*;
import java.io.*;

/**
 *
 * @author mingzhe
 */
public class AddItem extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            
            Item item = new Item(code, description, price);
            ItemService itemService = new ItemService(em);
            utx.begin();
            boolean success = itemService.addItem(item);
            utx.commit();
            
            HttpSession session = request.getSession();
            session.setAttribute("Success", success);
            response.sendRedirect("AddConfirm.jsp");
            
        }catch(Exception ex){
            String errorMessage = "An error occurred while processing the request: " + ex.getMessage();
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, errorMessage, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "Short description"; 
    }

   
}
