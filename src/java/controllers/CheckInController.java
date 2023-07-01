/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.CheckIn;
import repositories.CheckInRepository;
import services.CheckInService;
import static services.Utilities.sdfDateTime;

/**
 *
 * @author Dell
 */
@WebServlet(name = "CheckInController", urlPatterns = {"/checkIn"})
public class CheckInController extends HttpServlet {

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
            CheckInRepository cir = new CheckInRepository();
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
                case "readExcel": {
                    readExcel(request, response);
                    break;
                }
                case "readExcel1": {
                    readExcel1(request, response);
                    break;
                }
                case "delete":
                    delete(request, response);
                    break;

            }
        }
    }

    protected void listOf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CheckInRepository cir = new CheckInRepository();
        try {
            List<CheckIn> list = cir.select();
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
            throws ServletException, IOException {
        CheckInRepository cir = new CheckInRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create": {
                try {

//                  int checkInID = Integer.parseInt(request.getParameter("checkInID"));
                    Date checkInTime = sdfDateTime.parse(request.getParameter("checkInTime"));
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    CheckIn checkIn = new CheckIn(checkInTime, userID);
                    cir.create(checkIn);
//                  request.setAttribute("checkIn", checkIn);
                    response.sendRedirect(request.getContextPath() + "/checkIn/listOf.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            }
            case "cancel": {
                response.sendRedirect(request.getContextPath() + "/checkIn/listOf.do");
                break;
            }
        }

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CheckInRepository cir = new CheckInRepository();
        try {
            int checkInID = Integer.parseInt(request.getParameter("checkInID"));
            cir.delete(checkInID);
            response.sendRedirect(request.getContextPath() + "/checkIn/listOf.do");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void readExcel1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        CheckInRepository cir = new CheckInRepository();
        CheckInService cis = new CheckInService();
        CheckInRepository cir = new CheckInRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "readExcel":
                try {

                    String fileName = request.getParameter("fileName");
                    if (!fileName.equals("")) {
                        File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
                        String EXCEL_FILE_PATH = file.getAbsolutePath();
                        List<CheckIn> list = cis.readExcel1(EXCEL_FILE_PATH);
                        for (CheckIn c : list) {
                            CheckIn ci = new CheckIn(c.getCheckInTime(), c.getUserID());
                            System.out.println(c.getCheckInID() + "-" + c.getCheckInTime());
                            cir.create(ci);
                        }
                        response.sendRedirect(request.getContextPath() + "/checkIn/listOf.do");
                    } else {
                        request.setAttribute("message", "Please choose your file!!!");
                        request.getRequestDispatcher("/checkIn/listOf.do").forward(request, response);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message", e.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            default:
                break;
        }

    }

    protected void readExcel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
