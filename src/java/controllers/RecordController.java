/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Record;
import models.UserShift;
import repositories.RecordRepository;
import repositories.UserShiftRepository;
import services.RecordService;

/**
 *
 * @author DELL
 */
@WebServlet(name = "RecordController", urlPatterns = {"/record"})
public class RecordController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String controller = (String) request.getAttribute("controller");
            String action = (String) request.getAttribute("action");
            RecordRepository recr = new RecordRepository();
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

            }
        }
    }

    protected void listOf(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            RecordRepository rcr = new RecordRepository();
            List<Record> list = rcr.select();
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
            throws ServletException, IOException {
        try {
            UserShiftRepository usr = new UserShiftRepository();
            RecordService rcs = new RecordService();
            RecordRepository rcr = new RecordRepository();

            List<UserShift> listU = usr.select();
            for(UserShift us: listU){
                System.out.println(us.toString());
            }
            List<Record> listR = rcr.select1();
            if(listR==null){
                System.out.println("listR null");
            }else if(listR.isEmpty()){
                System.out.println("listR empty");
            }else{
                for (Record r : listR) {
                System.out.println(r.toString());
            }
            }
            
            
            
            System.out.println("rtyui");
            boolean checkList = false;
            for (UserShift us : listU) {
                boolean check = false;
                System.out.println("jkl");
                if (us.getStatus() == 2) {
                    System.out.println("-----------------------");
                    Record rc = rcs.createRecord(us.getUserID(), us.getShiftID(), us.getDate());
                    System.out.println(rc.toString());
                    System.out.println("son");
                    if (listR.isEmpty()) {
                        System.out.println("ilu");
                        System.out.println("createrc1" + rc.toString());
                        rcr.create(rc);
                        System.out.println("minh");
                        checkList = false;
                    } else {
                        System.out.println("ListR OK");
                        for (Record r : listR) {
                            if (rc.getUserID() == r.getUserID()
                                    && rc.getShiftID() == r.getShiftID()
                                    && rc.getDate().compareTo(r.getDate()) == 0) {
                                System.out.println("duplicate");
                                check = true;
                                checkList = true;
                                break;
                            }
                        }
                        if (check == false) {
                            System.out.println("createrc2" + rc.toString());
                            rcr.create(rc);
                        }
                    }
                }else {
                    request.setAttribute("message", "Please DONE UserShift before!!!");
                    request.getRequestDispatcher("/record/listOf.do").forward(request, response);
                }

            }
            if (checkList == false) {
                response.sendRedirect(request.getContextPath() + "/attendance/create.do");
            } else {
                response.sendRedirect(request.getContextPath() + "/attendance/list.do");
            }

//            request.setAttribute("listA", listA);
        } catch (Exception e) {

        }
    }

    private void create_handler(HttpServletRequest request, HttpServletResponse response) {
        //To change body of generated methods, choose Tools | Templates.
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
