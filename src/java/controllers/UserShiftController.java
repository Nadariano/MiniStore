/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.UserShift;
import repositories.UserShiftRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "UserShiftController", urlPatterns = {"/userShift"})
public class UserShiftController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String controller = (String) request.getAttribute("controller");
            String action = (String) request.getAttribute("action");
            UserShiftRepository usr = new UserShiftRepository();
            switch (action) {
                case "listOf":
                    listOf(request, response);
                    break;
                case "create":
                    create(request, response);
                    break;
                case "create_handler":
                    create_handler(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "update_handler":
                    update_handler(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
            }
        }
    }

    protected void listOf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserShiftRepository usr = new UserShiftRepository();
        try {
            List<UserShift> list = usr.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserShiftRepository usr = new UserShiftRepository();
        try {
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserShiftRepository usr = new UserShiftRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create":
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int shiftID = Integer.parseInt(request.getParameter("shiftID"));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
                    Date date = sdf.parse(request.getParameter("date"));
                    int status = Integer.parseInt(request.getParameter("status"));
                    String note = request.getParameter("note");
                    boolean isOT = Boolean.parseBoolean(request.getParameter("isOT"));
                    UserShift userShift = new UserShift(userID, shiftID, date, status, note, isOT);
                    request.setAttribute("userShift", userShift);
                    usr.create(userShift);
                    response.sendRedirect(request.getContextPath() + "/userShift/listOf.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "create");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/userShift/listOf.do");
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserShiftRepository usr = new UserShiftRepository();
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
            UserShift userShift = usr.read(userID);
            request.setAttribute("userShift", userShift);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void update_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserShiftRepository usr = new UserShiftRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    int shiftID = Integer.parseInt(request.getParameter("shiftID"));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
                    Date date = sdf.parse(request.getParameter("date"));
                    int status = Integer.parseInt(request.getParameter("status"));
                    String note = request.getParameter("note");
                    boolean isOT = Boolean.parseBoolean(request.getParameter("isOT"));
                    UserShift userShift = new UserShift(userID, shiftID, date, status, note, isOT);
                    usr.update(userShift); 
                    response.sendRedirect(request.getContextPath() + "/userShift/listOf.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/userShift/listOf.do");
        }
        
            
            
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserShiftRepository usr = new UserShiftRepository();
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
            int shiftID = Integer.parseInt(request.getParameter("shiftID"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
            Date date = sdf.parse(request.getParameter("date"));
            usr.delete(userID, shiftID, date);
//            usd.delete1(userID);
            //Chuyen den trang /toy?op=list
            response.sendRedirect(request.getContextPath() + "/userShift/listOf.do");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
