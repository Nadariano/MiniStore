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
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Record;
import repositories.RecordRepository;
import services.AttendanceService;
import static services.Utilities.sdfDate;
import static services.Utilities.sdfTime;

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
            case "done":
                try {
                    done(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "search":
                try {
                    search(request, response);
                } catch (Exception ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
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
//            case "create_handler":
//                try {
//                    create_handler(request, response);
//                } catch (SQLException ex) {
//                    //Hien trang thong bao loi
//                    ex.printStackTrace();//In thông báo chi tiết cho developer
//                    request.setAttribute("message", ex.getMessage());
//                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
//                }
//                break;
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

    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            AttendanceRepository af = new AttendanceRepository();
            List<Attendance> list = af.select();

            HttpSession session = request.getSession();
            List<Attendance> listSearch = (List<Attendance>) session.getAttribute("listSearch");

            if (listSearch != null) {
                list = listSearch;
            }
            request.setAttribute("list", list);

            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            //Hien trang thong bao loi
            ex.printStackTrace();//In thông báo chi tiết cho developer
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void listOfUsers(HttpServletRequest request, HttpServletResponse response)
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

    protected void updateOfUsers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    AttendanceRepository af = new AttendanceRepository();

                    String[] attendIDs = request.getParameterValues("attendID");
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    String[] notes = request.getParameterValues("note");
                    String[] confirms = request.getParameterValues("confirm");
                    String[] statusTexts = request.getParameterValues("statusText");
                    String[] statuses = request.getParameterValues("status");
                    for (int i = 0; i < confirms.length; i++) {
                        if (confirms[i].equalsIgnoreCase("Accepted")) {
                            statusTexts[i] = "Available";
                            statuses[i] = "1";
                        } else {
                            statusTexts[i] = "Not Available";
                            statuses[i] = "0";
                        }
                    }
                    if (notes.length == statuses.length) {
                        for (int i = 0; i < notes.length; i++) {
                            String note = notes[i];
                            String confirm = confirms[i];
                            String statusText = statusTexts[i];

                            // Thực hiện updateOfUsers cho mỗi phần tử trong mảng
                            af.updateOfUsers(attendIDs[i], statuses[i], notes[i]);
                        }
                    }
                    response.sendRedirect(request.getContextPath() + "/attendance/listOfUsers.do?userID=" + userID);
//                      request.getRequestDispatcher("/views/home/successconfirm.jsp").forward(request, response);

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

    protected void update(HttpServletRequest request, HttpServletResponse response)
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

    protected void update_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    AttendanceRepository ar = new AttendanceRepository();
                    int attendID = Integer.parseInt(request.getParameter("attendID"));
                    Date date = sdfDate.parse(request.getParameter("date"));
                    String fullName = request.getParameter("fullName");
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

                    Date checkIn = null;
                    if (!request.getParameter("checkIn").equals("")) {
                        checkIn = sdf.parse(request.getParameter("checkIn"));
                    }
                    
                    Date checkOut = null;
                    if (!request.getParameter("checkOut").equals("")){
                        checkOut = sdf.parse(request.getParameter("checkOut"));
                    }
                    
                    Date soonTime = null;
                    if (!request.getParameter("soonTime").equals("")) {
                        soonTime = sdfTime.parse(request.getParameter("soonTime"));
                    }

                    Date lateTime = null;
                    if (!request.getParameter("lateTime").equals("")) {
                        lateTime = sdfTime.parse(request.getParameter("lateTime"));
                    }

                    Date duration = null;
                    if (!request.getParameter("duration").equals("")) {
                        duration = sdfTime.parse(request.getParameter("duration"));
                    }
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
                    int shiftID = Integer.parseInt(request.getParameter("shiftID"));
                    Attendance attendance = new Attendance(attendID, date, checkIn, checkOut, lateTime, soonTime, duration, status, note, userID, shiftID, fullName, confirm, statusText);
                    System.out.println(attendance.toString());
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

    protected void done(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            AttendanceRepository ar = new AttendanceRepository();
            int status = 2;
            ar.done(status);
            response.sendRedirect(request.getContextPath() + "/paySlip/create.do");

        } catch (Exception ex) {
            //Hiện trang thông báo lỗi
            ex.printStackTrace();//In thông báo chi tiết cho developer
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

//    protected void create(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//        try {
//            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            request.setAttribute("message", ex.getMessage());
//            request.setAttribute("controller", "error");
//            request.setAttribute("action", "error");
//            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
//        }
//    }
//
//    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException, SQLException {
//        String op = request.getParameter("op");
//        switch (op) {
//            case "create":
//                try {
//                    AttendanceRepository af = new AttendanceRepository();
//                    int userID = Integer.parseInt(request.getParameter("userID"));
//                    Date date = sdfDate.parse(request.getParameter("date"));
//                    String fullName = request.getParameter("fullName");
//                    Date checkIn = sdfTime.parse(request.getParameter("checkIn"));
//                    Date checkOut = sdfTime.parse(request.getParameter("checkOut"));
//                    Date soonTime = sdfTime.parse(request.getParameter("soonTime"));
//                    Date lateTime = sdfTime.parse(request.getParameter("lateTime"));
//                    Date duration = sdfTime.parse(request.getParameter("duration"));
//                    int status = 0;
//                    String statusText = "Not Available";
//                    String confirm = "Denied";
//                    String note = "";
//                    Attendance attendance = new Attendance(userID, date, checkIn, checkOut, soonTime, lateTime, duration, status, note, userID, fullName, confirm, statusText);
//                    af.create(attendance);
//                    response.sendRedirect(request.getContextPath() + "/attendance/list.do");
//                } catch (Exception ex) {
//                    //Hiện trang thông báo lỗi
//                    ex.printStackTrace();//In thông báo chi tiết cho developer
//                    request.setAttribute("message", ex.getMessage());
//                    request.setAttribute("controller", "error");
//                    request.setAttribute("action", "error");
//                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
//                }
//                break;
//            case "cancel":
//                response.sendRedirect(request.getContextPath() + "/attendance/list.do");
//        }
//    }
    protected int countParams(String... params) {
        int count = 0;
        for (String param : params) {
            if (param != null && !param.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        HttpSession session = request.getSession();
        String op = request.getParameter("op");

        switch (op) {
            case "search":
                try {
                    String day = request.getParameter("day");
                    String month = request.getParameter("month");
                    String year = request.getParameter("year");
                    String fullName = request.getParameter("fullName");
                    AttendanceRepository af = new AttendanceRepository();
                    List<Attendance> list = null;

                    switch (countParams(day, month, year, fullName)) {

                        case 3:
                            String date = year + "-" + month + "-" + day;
                            list = af.search(date);
                            break;
                        case 2:
                            if ("".equals(year)) {
                                list = af.searchByDayAndMonth(day, month);
                            } else if ("".equals(month)) {
                                list = af.searchByDayAndYear(day, year);
                            } else {
                                list = af.searchByMonthAndYear(month, year);
                            }
                            break;
                        case 1:
                            if (!"".equals(day)) {
                                list = af.searchByDay(day);
                            } else if (!"".equals(month)) {
                                list = af.searchByMonth(month);
                            } else if (!"".equals(year)) {
                                list = af.searchByYear(year);
                            } else {
                                list = af.searchByName(fullName);
                            }
                            break;
                        default:
                            // Handle invalid input
                            break;
                    }

                    session.setAttribute("listSearch", list);
//                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                    response.sendRedirect(request.getContextPath() + "/attendance/list.do");

//                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                } catch (SQLException ex) {
                    // Display error page
                    ex.printStackTrace();// Print detailed message for developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            default:
                break;
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            System.out.println("asdfghj");
            RecordRepository rcr = new RecordRepository();
            AttendanceService as = new AttendanceService();
            AttendanceRepository ar = new AttendanceRepository();

            List<Record> list = rcr.select1();
            System.out.println("OTP");
            for (Record rc : list) {
                System.out.println("Minh so kute");
                Date lateTime = as.lateTime(rc.getDate(), rc.getInTime(),rc.getUserID(), rc.getShiftID());
                System.out.println("LateTime " + lateTime);
                Date soonTime = as.soonTime(rc.getDate(), rc.getOutTime(),rc.getUserID(), rc.getShiftID());
                System.out.println("SoonTime " + soonTime);
                Date duration = as.duration(rc.getInTime(), rc.getOutTime(), rc.getDate());
                System.out.println("Duration " + duration);
                int status = 0;
//                String statusText = "Not Available";
                String confirm = "Denied";
                String note = "";
                Attendance a = new Attendance(rc.getDate(), rc.getInTime(), rc.getOutTime(), lateTime, soonTime, duration, status, note, rc.getUserID(), rc.getShiftID(), confirm);
                System.out.println("attendance "+ a.toString());
                ar.create(a);
            }
//            }

            response.sendRedirect(request.getContextPath() + "/attendance/list.do");
//            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
//            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        AttendanceRepository ar = new AttendanceRepository();
        try {
            int attendID = Integer.parseInt(request.getParameter("attendID"));
            ar.delete(attendID);
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
