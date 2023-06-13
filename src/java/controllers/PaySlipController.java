/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.PaySlip;
import repositories.PaySlipRepository;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PaySlipController", urlPatterns = {"/paySlip"})
public class PaySlipController extends HttpServlet {

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
            PaySlipRepository psd = new PaySlipRepository();
            switch (action) {
                case "listOf":
                    listOf(request, response);
                    break;
                case "myPaySlip":
                    myPaySlip(request, response);
                    break;
                case "create":
                    create(request, response);
                    break;
                case "create_handler":
                    create_handler(request, response);
                    break;
                case "updateMyPaySlip":
                    updateMyPaySlip(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
                case "update_handler":
                    update_handler(request, response);
                    break;
                case "delete":
                    break;

            }
        }
    }

    protected void listOf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PaySlipRepository psd = new PaySlipRepository();
        try {
            List<PaySlip> list = psd.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
        }
    }

    protected void myPaySlip(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PaySlipRepository psd = new PaySlipRepository();
        try {
            int userID = Integer.parseInt(request.getParameter("userID"));
//            PaySlip paySlip = psd.myPaySlip(userID);
//            request.setAttribute("paySlip", paySlip);
            List<PaySlip> list = psd.select1(userID);
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
        PaySlipRepository psd = new PaySlipRepository();
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
        PaySlipRepository psd = new PaySlipRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create":
                try {
//                    int paySlipID = Integer.parseInt(request.getParameter("paySlipID"));
                    int userID = Integer.parseInt(request.getParameter("userID"));
//                    String fullName = request.getParameter("fullName");
                    float salary = Float.parseFloat(request.getParameter("salary"));
                    float bonus = Float.parseFloat(request.getParameter("bonus"));
                    float minus = Float.parseFloat(request.getParameter("minus"));
                    int status = Integer.parseInt(request.getParameter("status"));
//                    String statusText3 = request.getParameter("statusText3");
                    String note = request.getParameter("note");
                    PaySlip paySlip = new PaySlip(userID, salary, bonus, minus, status, note);
                    request.setAttribute("paySlip", paySlip);
                    psd.create(paySlip);
                    response.sendRedirect(request.getContextPath() + "/paySlip/listOf.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "create");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/paySlip/listOf.do");
        }
    }

    protected void updateMyPaySlip(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PaySlipRepository psd = new PaySlipRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "updateMyPaySlip":
                try {
                    int paySlipID = Integer.parseInt(request.getParameter("paySlipID"));
                    int userID = Integer.parseInt(request.getParameter("userID"));
                    String fullName = request.getParameter("fullName");
                    float salary = Float.parseFloat(request.getParameter("salary"));
                    float bonus = Float.parseFloat(request.getParameter("bonus"));
                    float minus = Float.parseFloat(request.getParameter("minus"));
                    int status = Integer.parseInt(request.getParameter("status"));
                    String statusText3 = request.getParameter("statusText3");
                    String note = request.getParameter("note");
                    String confirm = request.getParameter("confirm");
                    status = 0;
//                                String confirm = "Disagree";

                    if (status == 0) {
                        statusText3 = "Not Done";

                    } else {
                        statusText3 = "Done";
                    }
                    if (confirm.equalsIgnoreCase("Agree")) {
                        status = 1;
                        statusText3 = "Done";
                    }
                    if (confirm.equalsIgnoreCase("Disagree")) {
                        status = 0;
                        statusText3 = "Not Done";
                    }

                    PaySlip paySlip = new PaySlip(paySlipID, userID, fullName, salary, bonus, minus, status, statusText3, confirm, note);
                    psd.update(paySlip);
                    response.sendRedirect(request.getContextPath() + "/paySlip/myPaySlip.do?userID=" + userID);
//                                request.getRequestDispatcher("/views/paySlip/myPaySlip.jsp").forward(request, response);
//                                request.getRequestDispatcher(request.getContextPath() + "/paySlip/myPaySlip.do").forward(request, response);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PaySlipRepository psd = new PaySlipRepository();
        try {
            int paySlipID = Integer.parseInt(request.getParameter("paySlipID"));
            int userID = Integer.parseInt(request.getParameter("userID"));
            PaySlip paySlip = psd.read(userID, paySlipID);
            request.setAttribute("paySlip", paySlip);
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
        PaySlipRepository psd = new PaySlipRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int paySlipID = Integer.parseInt(request.getParameter("paySlipID"));
                    int userID = Integer.parseInt(request.getParameter("userID"));
//                    String fullName = request.getParameter("fullName");
                    float salary = Float.parseFloat(request.getParameter("salary"));
                    float bonus = Float.parseFloat(request.getParameter("bonus"));
                    float minus = Float.parseFloat(request.getParameter("minus"));
                    int status = Integer.parseInt(request.getParameter("status"));
//                    String statusText3 = request.getParameter("statusText3");
                    String note = request.getParameter("note");
//                    PaySlip paySlip = new PaySlip(paySlipID, userID, fullName, salary, bonus, minus, status, statusText3, note);
                    PaySlip paySlip = new PaySlip(paySlipID, userID, salary, bonus, minus, status, note);
                    psd.update(paySlip);
                    response.sendRedirect(request.getContextPath() + "/paySlip/listOf.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/paySlip/listOf.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PaySlipRepository psd = new PaySlipRepository();
        try {
            int paySlipID = Integer.parseInt(request.getParameter("paySlipID"));
            psd.delete(paySlipID);
            response.sendRedirect(request.getContextPath() + "/paySlip/listOf.do");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
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
