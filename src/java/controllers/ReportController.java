/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Report;
import repositories.ReportRepository;
import models.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.Account;
import static services.Utilities.sdfDate;

/**
 *
 * @author User
 */
@WebServlet(name = "ReportController", urlPatterns = {"/report"})
public class ReportController extends HttpServlet {

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
            case "list":
                list(request, response);
                break;
            case "listUserReport":
                listUserReport(request, response);
            case "update":
                update(request, response);
                break;
            case "update_handler":
                update_handler(request, response);
                break;
            case "create":
                try {
                    create(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "create_handler":
                try {
                    create_handler(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            default:
            //Show error page
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ReportRepository rf = new ReportRepository();
            List<Report> list = rf.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            //Hien trang thong bao loi
            ex.printStackTrace();//In thông báo chi tiết cho developer
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReportRepository rf = new ReportRepository();
        try {

            int reportID = Integer.parseInt(request.getParameter("reportID"));
            Report report = rf.read(reportID);

            request.setAttribute("report", report);

            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            //Hiện trang thông báo lỗi
            ex.printStackTrace();//In thông báo chi tiết cho developer
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    private void update_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    ReportRepository rf = new ReportRepository();
                    int reportID = Integer.parseInt(request.getParameter("reportID"));
//                    String reportTitle = request.getParameter("reportTitle");
//                    String typeName = request.getParameter("typeName");
//                    Date createDate = sdfDate.parse(request.getParameter("createDate"));
//                    String fullName = request.getParameter("fullName");
//                    String description = request.getParameter("description");
//                    Date plannedDate = sdfDate.parse(request.getParameter("plannedDate"));
//                    int userID = Integer.parseInt(request.getParameter("userID"));
                    String note = request.getParameter("note");
                    String statusText = request.getParameter("statusText");
                    int status = 1;
                    switch (statusText) {
                        case "Approved":
                            status = 0;
                            break;
                        case "Rejected":
                            status = 2;
                            break;
                        default:
                            status = 1;
                            break;
                    }

                    Report report = new Report(reportID, status, note);
                    rf.update(report);
                    response.sendRedirect(request.getContextPath() + "/report/list.do");
                } catch (Exception ex) {
                    //Hiện trang thông báo lỗi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/report/list.do");
        }
    }

    private void listUserReport(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Account acc = (Account) session.getAttribute("Account");
            int userID = acc.getUserID();
            ReportRepository rf = new ReportRepository();
            List<Report> list = rf.selectUserReport(userID);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            //Hien trang thong bao loi
            ex.printStackTrace();//In thông báo chi tiết cho developer
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            //Hiện trang thông báo lỗi
            ex.printStackTrace();//In thông báo chi tiết cho developer
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        switch (op) {
            case "create":
                try {
                    ReportRepository rf = new ReportRepository();
                    String reportTitle = request.getParameter("reportTitle");
                    int typeID = Integer.parseInt(request.getParameter("typeID"));
                    String description = request.getParameter("description");
                    String plannedDate = request.getParameter("plannedDate");
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    String note = "";
                    int status = 1;
//                    rf.create(reportTitle, description, status, note, userID);
                    rf.create(reportTitle, description, plannedDate, status, note, userID, typeID);
                    response.sendRedirect(request.getContextPath() + "/report/listUserReport.do");
                } catch (Exception ex) {
                    //Hiện trang thông báo lỗi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/report/listUserReport.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        ReportRepository rf = new ReportRepository();
        try {
            int reportID = Integer.parseInt(request.getParameter("reportID"));
            rf.delete(reportID);
            //Chuyen den trang /toy?op=list
            response.sendRedirect(request.getContextPath() + "/report/list.do");
        } catch (SQLException ex) {
            //Hien trang thong bao loi
            ex.printStackTrace();//In thông báo chi tiết cho developer
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
