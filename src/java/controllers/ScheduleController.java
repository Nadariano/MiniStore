/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ShiftTime;
import models.UserShift;
import repositories.ScheduleRepository;
import repositories.ShiftTimeRepository;
import repositories.UserShiftRepository;
import services.Utilities;

/**
 *
 * @author acer
 */
@WebServlet(name = "ScheduleController", urlPatterns = {"/schedule"})
public class ScheduleController extends HttpServlet {

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
            case "listAll":
                try {
                    listAll(request, response);
                } catch (SQLException ex) {
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "selectWeek":
                selectWeek(request, response);
                break;
            case "schedule-add":
                request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                break;
            default:
            //Show error page
        }
    }

    protected void listAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        ScheduleRepository sdr = new ScheduleRepository();
        UserShiftRepository usr = new UserShiftRepository();
        try {
            Object selectedWeek = session.getAttribute("selectedWeek");
            String week = sdr.listStartEndDates().get(0);
            if (selectedWeek != null) {
                week = (String) selectedWeek;
            }
            String stringStartDate = week.substring(0, 10);
            LocalDate startDate= Utilities.dateString(stringStartDate);
            List<String> weeks = sdr.listStartEndDates();
            List<String> listDays = Utilities.listDaysInWeek();
            List<LocalDate> listDates = Utilities.listDatesInWeek(startDate);
            List<LocalDate> startEndDates = sdr.startEndDates(startDate);
            List<ShiftTime> shifts = ShiftTimeRepository.select();
            List<UserShift> usersShiftList = UserShiftRepository.select();
            request.setAttribute("weeks", weeks);
            request.setAttribute("usersShiftList", usersShiftList);
            request.setAttribute("listDays", listDays);
            request.setAttribute("listDates", listDates);
            request.setAttribute("startEndDates", startEndDates);
            request.setAttribute("shifts", shifts);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void selectWeek(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String op = request.getParameter("op");
        switch (op) {
            case "filter": {
                try {
//                    int weekNo = Integer.parseInt(request.getParameter("week"));
                    String selectedWeek = request.getParameter("week");
                    session.setAttribute("selectedWeek", selectedWeek);
//                    request.setAttribute("week", week);
                    response.sendRedirect(request.getContextPath() + "/schedule/listAll.do");
                } catch (Exception ex) {
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
            }
            break;
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
