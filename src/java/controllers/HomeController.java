/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
import javax.servlet.http.HttpSession;
import models.Account;
import models.Report;
import repositories.ReportRepository;
import repositories.UsersRepository;

/**
 *
 * @author PHT
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

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
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "index":
                index(request, response);
                break;
            default:
            //Show error page
        }
    }

    protected void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        UsersRepository ur = new UsersRepository();
        Account acc = (Account) session.getAttribute("Account");
        String role = acc.getRoleName();
        switch (role) {
            case "ADMIN": {
                try {
                    int countAll = ur.countAll();
                    int countActive = ur.countIfStatus(1);
                    int countInActive = ur.countIfStatus(0);
                    int countBanned = ur.countIfStatus(2);
                    List<Integer> roleCount = ur.countBasedRole();
                    List<String> roleNames = ur.listRoleName();
                    request.setAttribute("allUser", countAll);
                    request.setAttribute("activeUser", countActive);
                    request.setAttribute("inactiveUser", countInActive);
                    request.setAttribute("bannedUser", countBanned);
                    request.setAttribute("roleCount", roleCount);
                    request.setAttribute("roleNames", roleNames);
                } catch (SQLException ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            break;
            case "SALE": {
                try {
                    int userID = acc.getUserID();
                    ReportRepository rf = new ReportRepository();
                    List<Report> list1 = rf.selectStatusProcessing(userID);
                    request.setAttribute("list1", list1);
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
            }
            break;
            
            case "GUARD": {
                try {
                    int userID = acc.getUserID();
                    ReportRepository rf = new ReportRepository();
                    List<Report> list1 = rf.selectStatusProcessing(userID);
                    request.setAttribute("list1", list1);
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
            }
            break;
        }
        request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
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
