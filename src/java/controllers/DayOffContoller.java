/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.DayOff;
import repositories.DayOffRepository;
import java.io.IOException;
import java.sql.SQLException;
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
 * @author Pc
 */
@WebServlet(name = "DayOffContoller", urlPatterns = {"/dayOff"})
public class DayOffContoller extends HttpServlet {

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
        DayOffRepository dof = new DayOffRepository();
        HttpSession session = request.getSession();

//        User user = (User) session.getAttribute("user");
//         if(user == null || !user.getdayOff().equals("")){
//            response.sendRedirect(request.getContextPath()+"/login.jsp");
//            return;
//        }
        switch (action) {
            case "index":
                try {
                    List<DayOff> list = dof.select();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//in thong bao loi chi tiet cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;
            case "create":
                request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                break;

            case "create_handler": {//xu li create form
                String op = request.getParameter("op");
                switch (op) {
                    case "create": {
                        try {
                            //Đọc dữ liệu từ client gửi lên
//                            int dayOffID = Integer.parseInt(request.getParameter("dayOffID"));

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = sdf.parse(request.getParameter("date"));
                            float coefficient = Float.parseFloat(request.getParameter("coefficient"));
                            String description = request.getParameter("description");
                            int status = Integer.parseInt(request.getParameter("status"));
                            String note = request.getParameter("note");
                            //Tao dayOff moi
                            DayOff dayOff = new DayOff(date, coefficient, description, status, note);
                            //Luu thong tin vao db de chinh sua
                            request.setAttribute("dayOff", dayOff);
                            dof = new DayOffRepository();
                            List<DayOff> list = dof.select();
                            //Truyen list cho view de tao combo box
                            request.setAttribute("list", list);
                            dof.create(dayOff);
                            //Hiển thị danh sách các mẫu tin của table dayOff
                            /*
                    List<DayOff> list = tf.select();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("/dayOff.jsp").forward(request, response);
                             */
                            response.sendRedirect(request.getContextPath() + "/dayOff/index.do");
                        } catch (Exception ex) {
                            //Hien trang thong bao loi
                            ex.printStackTrace();//in thong bao loi chi tiet cho developer
                            request.setAttribute("message", ex.getMessage());
                            request.setAttribute("action", "create");
                            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                        }
                    }
                    break;
                    case "cancel":
                        response.sendRedirect(request.getContextPath() + "/dayOff/index.do");
                        break;
                }
            }
            break;
            case "edit"://Hien form de sua du lieu
                try {
                    //Đọc mẫu tin cần sửa vào đối tượng dayOff
                    int dayOffID = Integer.parseInt(request.getParameter("dayOffID"));
                    DayOff dayOff = dof.read(dayOffID);
                    //Lưu dayOff vào request để truyền cho view edit.jsp
                    request.setAttribute("dayOff", dayOff);
                    //Chuyển request & response đến view edit.jsp để xử lý tiếp
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//in thong bao loi chi tiet cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;

            case "edit_handler": {//Luu thong tin vao db
                String op = request.getParameter("op");
                switch (op) {
                    case "edit":
                        try {
                            //Đọc dữ liệu từ client gửi lên

                            int dayOffID = Integer.parseInt(request.getParameter("dayOffID"));

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = sdf.parse(request.getParameter("date"));
                            float coefficient = Float.parseFloat(request.getParameter("coefficient"));
                            String description = request.getParameter("description");
                            int status = Integer.parseInt(request.getParameter("status"));
                            String note = request.getParameter("note");
                            //Cập nhật dữ liệu vào db
                            DayOff dayOff = new DayOff(dayOffID, date, coefficient, description, status, note);
                            dof.update(dayOff);
                            //Hiển thị danh sách các mẫu tin của table dayOff                         
                            response.sendRedirect(request.getContextPath() + "/dayOff/index.do");
                        } catch (Exception ex) {
                            //Hien trang thong bao loi
                            ex.printStackTrace();//in thong bao loi chi tiet cho developer
                            request.setAttribute("message", ex.getMessage());
                            request.setAttribute("controller", "error");
                            request.setAttribute("action", "error");
                            request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                        }
                        break;
                    case "cancel":
                        response.sendRedirect(request.getContextPath() + "/dayOff/index.do");
                        break;
                }
            }
            break;

            case "delete":
                try {
                    int dayOffID = Integer.parseInt(request.getParameter("dayOffID"));
                    dof.delete(dayOffID);
                    //Chuyen den trang /dayOff?op=list
                    response.sendRedirect(request.getContextPath() + "/dayOff/index.do");
                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//in thong bao loi chi tiet cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                }
                break;

            default:
            //Show error page
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
