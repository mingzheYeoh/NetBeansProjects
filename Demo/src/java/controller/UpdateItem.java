package controller;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.UserTransaction;
import model.*;
import java.io.*;
import java.util.logging.*;

public class UpdateItem extends HttpServlet {
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ItemService itemService = new ItemService(em);
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            Double price = Double.parseDouble(request.getParameter("price"));
            Item item = new Item(code, description, price);

            utx.begin();
            boolean success = itemService.updateItem(item);
            utx.commit();
            HttpSession session = request.getSession();
            session.setAttribute("success", success);
            response.sendRedirect("UpdateConfirm.jsp");
        } catch (Exception ex) {
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
