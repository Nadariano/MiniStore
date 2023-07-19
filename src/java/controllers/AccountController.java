/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Account;
import repositories.AccountRepository;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Users;
import repositories.UsersRepository;
import services.Utilities;

/**
 *
 * @author acer
 */
@WebServlet(name = "AccountController", urlPatterns = {"/account"})
public class AccountController extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "login":
                request.getRequestDispatcher("/views/account/login.jsp").forward(request, response);
                break;
            case "login_handler":
                login_handler(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "profile":
                request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                break;
            case "updateProfile":
                request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                break;
            case "updateProfile_handler":
                updateProfile_handler(request, response);
                break;
            case "changePassword":
                request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                break;
            case "changePassword_handler":
                changePassword_handler(request, response);
                break;
            default:
                break;
        }
    }

    protected void login_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException {
        String op = request.getParameter("op");
        switch (op) {
            case "login":
                String userName = request.getParameter("userName");
                String hashedpassword = Utilities.hash(request.getParameter("password"));
                AccountRepository ar = new AccountRepository();
                Account acc = ar.login(userName, hashedpassword);
                if (acc != null) {
                    if (ar.isActive(acc.getStatus())) {
                        HttpSession session = request.getSession();
                        session.setAttribute("Account", acc);
                    } else request.setAttribute("message", "Your account is currently unusable. Contact the manager for more detail.");
                } else {
                    request.setAttribute("message", "Incorrect userName or password, please check again.");
                }
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            default:
                break;
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Xoa session
        HttpSession session = request.getSession();
        session.invalidate();
        //Quay ve home page
        request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
    }

    protected void updateProfile_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        AccountRepository ar = new AccountRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    HttpSession session = request.getSession();
                    Account acc = (Account) session.getAttribute("Account");
                    int userID = acc.getUserID();
                    String userName = request.getParameter("userName");
                    String fullName = request.getParameter("fullName");
                    String avatar = request.getParameter("avatar");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String address = request.getParameter("address");
                    Account updatedaccount = new Account(userID, userName, fullName, avatar, address, phone, email);
                    ar.update(updatedaccount);
                    request.setAttribute("message", "Successfully");
                    session.setAttribute("Account", ar.read(userID));
                    request.getRequestDispatcher("/account/profile.do").forward(request, response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/account/profile.do");
        }
    }

    protected void changePassword_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        AccountRepository ar = new AccountRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "change":
                try {
                    HttpSession session = request.getSession();
                    Account acc = (Account) session.getAttribute("Account");
                    int userID = acc.getUserID();
                    String oldPass = request.getParameter("oldPass");
                    boolean isFound = ar.comparePass(userID, oldPass);
                    String successMessage = null, failMessage = null;
                    String newPass1 = request.getParameter("newPass1");
                    String newPass2 = request.getParameter("newPass2");
                    if (isFound == true && !oldPass.isEmpty()) {
                        if (newPass1.isEmpty() || newPass2.isEmpty()) {
                            failMessage = "New password must not be blank";
                        } else if (newPass2.equals(newPass1) && !newPass2.isEmpty()) {
                            ar.updatePass(userID, newPass2);
                            successMessage = "Your password has been changed";
                        } else {
                            failMessage = "You have re-enter the wrong password, please try again.";
                        }
                    } else {
                        failMessage = "The current Password is incorrect, please try again.";
                    }
                    request.setAttribute("successMsg", successMessage);
                    request.setAttribute("failMsg", failMessage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                }
                request.getRequestDispatcher("/account/changePassword.do").forward(request, response);
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/account/profile.do");
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
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
