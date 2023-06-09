/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Users;
import repositories.UsersRepository;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.Utilities;

/**
 *
 * @author Dell
 */
@WebServlet(name = "UsersController", urlPatterns = {"/users"})
public class UsersController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        UsersRepository ur = new UsersRepository();
        switch (action) {
            case "listOf":
                try {
                    listOf(request, response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "create":
                try {
                    create(request, response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "create_handler":
                try {
                    create_handler(request, response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "update":
                update(request, response);
                break;
            case "update_handler": {
                update_handler(request, response);
            }
            break;
//            case "delete":
//                try {
//                    delete(request, response);
//                } catch (SQLException ex) {
//                    ex.printStackTrace();
//                    request.setAttribute("message", ex.getMessage());
//                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
//                }
//                break;
            default:
                break;
        }

    }

    protected void listOf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        UsersRepository ur = new UsersRepository();
        try {
            List<Users> list = ur.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersRepository ur = new UsersRepository();
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
            Users users = ur.read(userID);
            request.setAttribute("users", users);
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
        UsersRepository ur = new UsersRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    String userName = request.getParameter("userName");
                    String hashedpassword = Utilities.hash(request.getParameter("password"));
                    String fullName = request.getParameter("fullName");
                    String avatar = request.getParameter("avatar");
                    String address = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    int status = Integer.parseInt(request.getParameter("status"));
                    String note = request.getParameter("note");
                    int roleID = Integer.parseInt(request.getParameter("roleID"));
                    Users users = new Users(userID, userName, hashedpassword, fullName, avatar, address, phone, email, status, note, roleID);
                    ur.update(users);
                    response.sendRedirect(request.getContextPath() + "/users/listOf.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/users/listOf.do");
        }
    }

//    protected void delete(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//        UsersRepository ur = new UsersRepository();
//        try {
//            int userID = Integer.parseInt(request.getParameter("userID"));
//            ur.delete(userID);
//            response.sendRedirect(request.getContextPath() + "/users/listOf.do");
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            request.setAttribute("message", ex.getMessage());
//            request.setAttribute("controller", "error");
//            request.setAttribute("action", "error");
//            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
//        }
//    }
    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        UsersRepository ur = new UsersRepository();
        try {
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        UsersRepository ur = new UsersRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create":
                try {
                    String userName = request.getParameter("userName");
                    String hashedpassword = Utilities.hash(request.getParameter("password"));
                    String fullName = request.getParameter("fullName");
                    String avatar = request.getParameter("avatar");
                    String address = request.getParameter("address");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    int status = Integer.parseInt(request.getParameter("status"));
                    String note = request.getParameter("note");
                    int roleID = Integer.parseInt(request.getParameter("roleID"));
                    Users users = new Users(userName, hashedpassword, fullName, avatar, address, phone, email, status, note, roleID);
                    request.setAttribute("users", users);
                    ur.create(users);
                    response.sendRedirect(request.getContextPath() + "/users/listOf.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "create");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/users/listOf.do");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
