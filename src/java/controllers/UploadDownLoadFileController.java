/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Dell
 */
@WebServlet(name = "UploadDownLoadFileController", urlPatterns = {"/uploadDownloadFile"})
public class UploadDownLoadFileController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String controller = (String) request.getAttribute("controller");
            String action = (String) request.getAttribute("action");
            switch (action) {
                case "index":
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                case "downloadFile":
                    downloadFile(request, response);
                    break;

                case "uploadFile":
                    request.getRequestDispatcher("/layouts/main.jsp").forward(request, response);
                    break;
            }
        }
    }

    protected void downloadFile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        if (fileName == null || fileName.equals("")) {
            throw new ServletException("File Name can't be null or empty");
        }
        File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileName);
        if (!file.exists()) {
            throw new ServletException("File doesn't exists on server.");
        }
        System.out.println("File location on server::" + file.getAbsolutePath());
        ServletContext ctx = getServletContext();
        InputStream fis = new FileInputStream(file);
        String mimeType = ctx.getMimeType(file.getAbsolutePath());
        response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        ServletOutputStream os = response.getOutputStream();
        byte[] bufferData = new byte[1024];
        int read = 0;
        while ((read = fis.read(bufferData)) != -1) {
            os.write(bufferData, 0, read);
        }
        os.flush();
        os.close();
        fis.close();
        System.out.println("File downloaded at client successfully");
    }

    @Override
    public void init() throws ServletException {
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
        fileFactory.setRepository(filesDir);
        this.uploader = new ServletFileUpload(fileFactory);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new ServletException("Content type is not multipart/form-data");
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.write("<html><head></head><body>");
        try {

            List<FileItem> fileItemsList = uploader.parseRequest(request);
//            System.out.println("fileItemsList:" + fileItemsList);
            if (fileItemsList != null) {
                Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
                System.out.println("fileItemsIterator:" + fileItemsIterator);
                while (fileItemsIterator.hasNext()) {
                    FileItem fileItem = fileItemsIterator.next();
                    System.out.println("FieldName=" + fileItem.getFieldName());
                    System.out.println("FileName=" + fileItem.getName());
                    System.out.println("ContentType=" + fileItem.getContentType());
                    System.out.println("Size in bytes=" + fileItem.getSize());
                    File file = new File(request.getServletContext().getAttribute("FILES_DIR") + File.separator + fileItem.getName());
                    System.out.println("Absolute Path at server=" + file.getAbsolutePath());
                    fileItem.write(file);
//                request.setAttribute("message", "Upload successfully");
                    out.write("File " + fileItem.getName() + " uploaded successfully.");
//                request.getRequestDispatcher("/checkIn/listOf.do").forward(request, response);
                    out.write("<br>");
                    out.write("<a href=\"index.do" + "\">Back" + "</a>");
//                out.write("<br>");
//                out.write("<a href=\"downloadFile.do?fileName=" + fileItem.getName() + "\">Download " + fileItem.getName() + "</a>");
                }
            } else {
                request.setAttribute("message", "Please choose your file!!!");
                 request.getRequestDispatcher("/uploadDowloadFile/index.do").forward(request, response);
            }

        } catch (FileUploadException e) {
            out.write("Exception in uploading file.");
            out.write("<br>");
            out.write("<a href=\"index.do" + "\">Back" + "</a>");
            e.printStackTrace();
        } catch (Exception e) {
            out.write("Exception in uploading file.");
            out.write("<br>");
            out.write("<a href=\"index.do" + "\">Back" + "</a>");
            e.printStackTrace();
        }
        out.write("</body></html>");
    }
}
