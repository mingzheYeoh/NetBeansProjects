package controller;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Item;
import model.ItemService;
import java.io.*;
import java.util.List;
import java.util.logging.*;

/**
 *
 * @author mingzhe
 */
public class View extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        try {
            ItemService itemService = new ItemService(em);
            List<Item> itemList = itemService.findAllItem();

            HttpSession session = request.getSession();
            session.setAttribute("itemList", itemList);

            response.sendRedirect("Display.jsp");

        } catch (Exception ex) {
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
                    
        }
    }
    

}
