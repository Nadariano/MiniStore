/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Role;
import repositories.RoleRepository;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author acer
 */
@WebServlet(name = "RoleController", urlPatterns = {"/role"})
public class RoleController extends HttpServlet {

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
        RoleRepository rf = new RoleRepository();
        HttpSession session = request.getSession();

//        User user = (User) session.getAttribute("user");
//         if(user == null || !user.getRole().equals("")){
//            response.sendRedirect(request.getContextPath()+"/login.jsp");
//            return;
//        }
        switch (action) {
            case "index":
                try {
                    List<Role> list = rf.select();
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
                            
                            String roleName = request.getParameter("roleName");
                            int roleStatus = Integer.parseInt(request.getParameter("roleStatus"));
                            String description = request.getParameter("description");
                            //Tao roles moi
                            Role roles = new Role( roleName, roleStatus, description);
                            //Luu thong tin vao db de chinh sua
                          request.setAttribute("roles", roles);
                            rf = new RoleRepository();
                            List<Role> list = rf.select();
                            //Truyen list cho view de tao combo box
                            request.setAttribute("list", list);
                           rf.create(roles);
                            //Hiển thị danh sách các mẫu tin của table roles
                            /*
                    List<Roles> list = tf.select();
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("/roles.jsp").forward(request, response);
                             */
                            response.sendRedirect(request.getContextPath() + "/role/index.do");
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
                        response.sendRedirect(request.getContextPath() + "/role/index.do");
                        break;
                }
            }
            break;
                case "edit"://Hien form de sua du lieu
                try {
                    //Đọc mẫu tin cần sửa vào đối tượng roles
                  int roleID = Integer.parseInt(request.getParameter("roleID"));
                    Role roles = rf.read(roleID);
                    //Lưu roles vào request để truyền cho view edit.jsp
                    request.setAttribute("roles", roles);
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
                             int roleID = Integer.parseInt(request.getParameter("roleID"));
                           String roleName = request.getParameter("roleName");
                            int roleStatus = Integer.parseInt(request.getParameter("roleStatus"));
                            String description = request.getParameter("description");
                           
                            
                            //Cập nhật dữ liệu vào db
                             Role roles = new Role(roleID, roleName, roleStatus, description);
                            rf.update(roles);
                            //Hiển thị danh sách các mẫu tin của table roles                         
                            response.sendRedirect(request.getContextPath() + "/role/index.do");
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
                        response.sendRedirect(request.getContextPath() + "/role/index.do");
                        break;
                }
            }
            break;

            case "delete":
                try {
                    int roleID = Integer.parseInt(request.getParameter("roleID"));
                    rf.delete(roleID);
                    //Chuyen den trang /roles?op=list
                    response.sendRedirect(request.getContextPath() + "/role/index.do");
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
