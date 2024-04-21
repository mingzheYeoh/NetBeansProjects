package controller;

import model.Item;
import model.ItemService;
import java.io.*;
import java.util.logging.*;
import jakarta.persistence.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class SearchItem extends HttpServlet {

    @PersistenceContext
    EntityManager em;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ItemService itemService = new ItemService(em);
            HttpSession session = request.getSession();
            String code = (String) session.getAttribute("code");
            String button = (String) session.getAttribute("button");

            Item item = itemService.findItemByCode(code);

            session.setAttribute("item", item);
            if (button.equals("Delete")) {
                response.sendRedirect("secureAdmin/DeleteConfirmation.jsp");
            } else {
                response.sendRedirect("secureAdmin/UpdateConfirmation.jsp");
            }
  
        } catch (Exception ex) {
            Logger.getLogger(AddItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
