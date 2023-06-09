/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ShiftTime;
import repositories.ShiftTimeRepository;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

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
@WebServlet(name = "ShiftTimeController", urlPatterns = {"/shiftTime"})
public class ShiftTimeController extends HttpServlet {

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
            ShiftTimeRepository str = new ShiftTimeRepository();
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
        ShiftTimeRepository str = new ShiftTimeRepository();
        try {
            List<ShiftTime> list = str.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShiftTimeRepository str = new ShiftTimeRepository();
        try {
//                        int shiftID = Integer.parseInt(request.getParameter("shiftID"));
//                        ShiftTime shiftTime = std.read(shiftID);
//                        request.setAttribute("shiftTime", shiftTime);
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
            throws ServletException, IOException {
        ShiftTimeRepository str = new ShiftTimeRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create":
                try {
//                                int shiftID = Integer.parseInt(request.getParameter("shiftID"));
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date timeStart = sdf.parse(request.getParameter("timeStart"));
                    Date timeEnd = sdf.parse(request.getParameter("timeEnd"));
                    float coeShift = Float.parseFloat(request.getParameter("coeShift"));
                    float coeOT = Float.parseFloat(request.getParameter("coeOT"));
                    float wage = Float.parseFloat(request.getParameter("wage"));
                    int status = Integer.parseInt(request.getParameter("status"));
                    String note = request.getParameter("note");
                    ShiftTime shiftTime = new ShiftTime(timeStart, timeEnd, coeShift, coeOT, wage, status, note);
                    request.setAttribute("shiftTime", shiftTime);
                    str.create(shiftTime);
                    response.sendRedirect(request.getContextPath() + "/shiftTime/listOf.do");
                } catch (Exception ex) {
                    //Hiện lại create form để nhập lại dữ liệu
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "create");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/shiftTime/listOf.do");
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShiftTimeRepository str = new ShiftTimeRepository();
        try {
            int shiftID = Integer.parseInt(request.getParameter("shiftID"));
            ShiftTime shiftTime = str.read(shiftID);
            request.setAttribute("shiftTime", shiftTime);
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
        ShiftTimeRepository str = new ShiftTimeRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int shiftID = Integer.parseInt(request.getParameter("shiftID"));
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                    Date timeStart = sdf.parse(request.getParameter("timeStart"));
                    Date timeEnd = sdf.parse(request.getParameter("timeEnd"));
                    float coeShift = Float.parseFloat(request.getParameter("coeShift"));
                    float coeOT = Float.parseFloat(request.getParameter("coeOT"));
                    float wage = Float.parseFloat(request.getParameter("wage"));
                    int status = Integer.parseInt(request.getParameter("status"));
                    String note = request.getParameter("note");
                    ShiftTime shiftTime = new ShiftTime(shiftID, timeStart, timeEnd, coeShift, coeOT, wage, status, note);
                    str.update(shiftTime);
                    response.sendRedirect(request.getContextPath() + "/shiftTime/listOf.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/shiftTime/listOf.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ShiftTimeRepository str = new ShiftTimeRepository();
        try {
            int shiftID = Integer.parseInt(request.getParameter("shiftID"));
            str.delete(shiftID);
            response.sendRedirect(request.getContextPath() + "/shiftTime/listOf.do");
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
