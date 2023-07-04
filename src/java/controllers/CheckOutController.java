/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.CheckOut;
import repositories.CheckOutRepository;
import services.CheckOutService;
import static services.Utilities.sdfDateTime;

/**
 *
 * @author Dell
 */
@WebServlet(name = "CheckOutController", urlPatterns = {"/checkOut"})
public class CheckOutController extends HttpServlet {

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
            CheckOutRepository cir = new CheckOutRepository();
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
                case "delete":
                    delete(request, response);
                    break;
            }
        }
    }

    protected void listOf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CheckOutRepository cor = new CheckOutRepository();
        try {
            List<CheckOut> list = cor.select();
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
        CheckOutRepository cir = new CheckOutRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create": {
                try {
//                  int checkOutID = Integer.parseInt(request.getParameter("checkOutID"));
                    Date checkOutTime = sdfDateTime.parse(request.getParameter("checkOutTime"));
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    CheckOut checkOut = new CheckOut(checkOutTime, userID);
                    cir.create(checkOut);
//                  request.setAttribute("checkOut", checkOut);
                    response.sendRedirect(request.getContextPath() + "/checkOut/listOf.do");
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
                response.sendRedirect(request.getContextPath() + "/checkOut/listOf.do");
            }
        }

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CheckOutRepository cir = new CheckOutRepository();
        try {
            int checkOutID = Integer.parseInt(request.getParameter("checkOutID"));
            cir.delete(checkOutID);
            response.sendRedirect(request.getContextPath() + "/checkOut/listOf.do");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void readExcel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        CheckOutRepository cir = new CheckOutRepository();
        CheckOutService cos = new CheckOutService();
        String op = request.getParameter("op");
        switch (op) {
            case "readExcel":
                try {
                    String fileName = request.getParameter("fileName");
                    File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
                    String EXCEL_FILE_PATH = file.getAbsolutePath();
                    cos.readExcel(EXCEL_FILE_PATH);
                    response.sendRedirect(request.getContextPath() + "/checkOut/listOf.do");
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message", e.getMessage());
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            default:
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
