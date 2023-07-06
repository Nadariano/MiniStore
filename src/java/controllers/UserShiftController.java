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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Account;
import models.ShiftTime;
import models.Users;
import repositories.ShiftTimeRepository;
import repositories.UsersRepository;
import services.Utilities;
import static services.Utilities.sdfDate;

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
                case "selectWeek":
                    selectWeek(request, response);
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
        HttpSession session = request.getSession();
        try {
            List<UserShift> list = UserShiftRepository.select();
            Account acc = (Account) session.getAttribute("Account");
            String roleName = acc.getRoleName();
            int userID = acc.getUserID();
            if (!roleName.equals("MANAGER")) {
                list = usr.selectByUser(userID);
            }
            request.setAttribute("list", list);
            //Add for BLOCK View
            Object selectedWeek = session.getAttribute("selectedWeek");
            String week = Utilities.listStartEndDates().get(2);
            if (selectedWeek != null) {
                week = (String) selectedWeek;
            }
            String stringStartDate = week.substring(0, 10);
            LocalDate startDate = Utilities.dateString(stringStartDate);

            List<String> weeks = Utilities.listStartEndDates();
            List<String> listDays = Utilities.listDaysInWeek();
            List<LocalDate> listLocalDates = Utilities.listDatesInWeek(startDate);
            List<LocalDate> startEndDates = Utilities.startEndDates(startDate);
            List<ShiftTime> shifts = ShiftTimeRepository.select();
            List<Date> listDates = Utilities.listDate(listLocalDates);
            request.setAttribute("week", week);
            request.setAttribute("weeks", weeks);
            request.setAttribute("listDays", listDays);
            request.setAttribute("listLocalDates", listLocalDates);
            request.setAttribute("listDates", listDates);
            request.setAttribute("startEndDates", startEndDates);
            request.setAttribute("shifts", shifts);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
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
                    if (selectedWeek != null) {
                        session.setAttribute("selectedWeek", selectedWeek);
                    }
//                    request.setAttribute("week", week);
                    response.sendRedirect(request.getContextPath() + "/userShift/listOf.do");
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

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserShiftRepository usr = new UserShiftRepository();
        try {
            List<Users> userList = UsersRepository.select();
            request.setAttribute("usl", userList);
            int shiftID = 0;
            String date = null;
            shiftID = Integer.parseInt(request.getParameter("shiftID"));
            date = request.getParameter("date");
            if ((shiftID != 0) && (date != null)) {
                request.setAttribute("shiftID", shiftID);
                request.setAttribute("date", date);
            }
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
                    Date date = sdfDate.parse(request.getParameter("date"));
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
            int shiftID = Integer.parseInt(request.getParameter("shiftID"));
            Date date = sdfDate.parse(request.getParameter("date"));
            UserShift userShift = usr.read(userID, shiftID, date);
            request.setAttribute("userShift", userShift);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
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
                    Date date = sdfDate.parse(request.getParameter("date"));
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
            Date date = sdfDate.parse(request.getParameter("date"));
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
