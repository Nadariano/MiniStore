/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Attendance;
import repositories.AttendanceRepository;
import models.Report;
import repositories.ReportRepository;
import models.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
@WebServlet(name = "AttendanceController", urlPatterns = {"/attendance"})
public class AttendanceController extends HttpServlet {

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
                try {
                    list(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "update":
                try {
                    update(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "update_handler":
                try {
                    update_handler(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "listOfUsers":
                try {
                    listOfUsers(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "updateOfUsers":
                try {
                    updateOfUsers(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
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

    public void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            AttendanceRepository af = new AttendanceRepository();
            List<Attendance> list = af.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            //Hien trang thong bao loi
            ex.printStackTrace();//In thông báo chi tiết cho developer
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    private void listOfUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
            AttendanceRepository af = new AttendanceRepository();
            List<Attendance> list = af.selectUserAttendance(userID);
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            //Hien trang thong bao loi
            ex.printStackTrace();//In thông báo chi tiết cho developer
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    private void updateOfUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    AttendanceRepository af = new AttendanceRepository();
                    int attendID = Integer.parseInt(request.getParameter("attendID"));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(request.getParameter("date"));
                    String fullName = request.getParameter("fullName");
                    Time checkIn = Time.valueOf(request.getParameter("checkIn"));
                    Time checkOut = Time.valueOf(request.getParameter("checkOut"));
                    Time lateTime = Time.valueOf(request.getParameter("lateTime"));
                    Time overTime = Time.valueOf(request.getParameter("overTime"));
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    String note = request.getParameter("note");
                    String statusText = "Unknown";
                    String confirm = request.getParameter("confirm");
                    int status = 2;
                    if (confirm.equalsIgnoreCase("Accepted")) {
                        statusText = "Available";
                        status = 1;
                    } else {
                        statusText = "Not Available";
                        status = 0;
                    }

                    Attendance attendance = new Attendance(attendID, date, checkIn, checkOut, lateTime, overTime, status, note, userID, fullName, confirm, statusText);
                    af.update(attendance);
                    response.sendRedirect(request.getContextPath() + "/attendance/listOfUsers.do?userID="+ userID);

                } catch (Exception ex) {
                    //Hiện trang thông báo lỗi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            default:
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        AttendanceRepository ar = new AttendanceRepository();
        try {

            int attendID = Integer.parseInt(request.getParameter("attendID"));
            Attendance attendance = ar.read(attendID);

            request.setAttribute("attendance", attendance);

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
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    AttendanceRepository ar = new AttendanceRepository();
                    int attendID = Integer.parseInt(request.getParameter("attendID"));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(request.getParameter("date"));
                    String fullName = request.getParameter("fullName");
                    Time checkIn = Time.valueOf(request.getParameter("checkIn"));
                    Time checkOut = Time.valueOf(request.getParameter("checkOut"));
                    Time lateTime = Time.valueOf(request.getParameter("lateTime"));
                    Time overTime = Time.valueOf(request.getParameter("overTime"));
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    String note = request.getParameter("note");
                    String statusText = request.getParameter("statusText");
                    String confirm = request.getParameter("confirm");

                    int status = 1;
                    if (statusText.equalsIgnoreCase("Available")) {
                        status = 1;
                    } else {
                        status = 0;
                    }

                    Attendance attendance = new Attendance(attendID, date, checkIn, checkOut, lateTime, overTime, status, note, userID, fullName, confirm, statusText);
                    ar.update(attendance);
                    response.sendRedirect(request.getContextPath() + "/attendance/list.do");

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
                response.sendRedirect(request.getContextPath() + "/attendance/list.do");
                break;
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
         try {
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
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
                    AttendanceRepository af = new AttendanceRepository();
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf1.parse(request.getParameter("date"));
                    String fullName = request.getParameter("fullName");
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date checkIn = sdf.parse(request.getParameter("checkIn"));
                    Date checkOut = sdf.parse(request.getParameter("checkOut"));
                    Date lateTime = sdf.parse(request.getParameter("lateTime"));
                    Date overTime = sdf.parse(request.getParameter("overTime"));
                    int status = 0;
                    String statusText = "Not Available";
                    String confirm = "Denied";
                    String note = "";
                    Attendance attendance = new Attendance(userID, date, checkIn, checkOut, lateTime, overTime, status, note, userID, fullName, confirm, statusText);
                    af.create(attendance);
                    response.sendRedirect(request.getContextPath() + "/attendance/list.do");
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
                response.sendRedirect(request.getContextPath() + "/attendance/list.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        AttendanceRepository ar = new AttendanceRepository();
        try {
            int attendID = Integer.parseInt(request.getParameter("attendID"));
            ar.delete(attendID);
            //Chuyen den trang /toy?op=list
            response.sendRedirect(request.getContextPath() + "/attendance/list.do");
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
