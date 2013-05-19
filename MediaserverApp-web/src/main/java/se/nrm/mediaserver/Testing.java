/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nrm.mediaserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import se.nrm.mediaserver.domain.MediaService;
import se.nrm.mediaserver.entity.Image;
import se.nrm.mediaserver.entity.Media;

/**
 *
 * @author ingimar
 */
@WebServlet(name = "Testing", urlPatterns = {"/Testing"})
public class Testing extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Testing</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>11:04 Testing at " + request.getContextPath() + "</h1>");
            MediaService outreach = this.outreach();
            out.println("<h1>11:04 Testing at " + outreach + "</h1>");
            out.println("<h1>11:04 Testing at " + outreach.test() + "</h1>");
            Media media = this.get();
            out.println("<h1>11:04 Testing at " + media + "</h1>");
            outreach.save(media);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private Media get() {
        Media media = new Image();
        media.setFilename("Butterfly-13Maj-kl1525.jpg");
        media.setOwner("Larssons");
        return media;
    }

    private MediaService outreach() {
        MediaService bean = null;
        try {
            Properties jndiProps = new Properties();
            jndiProps.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.10.139"); // 192.168.10.139 , 172.16.34.31
            Context ctx = new InitialContext(jndiProps);
            //   bean = (MediaService) ctx.lookup("java:global/MediaserverApp-ejb/MediaServiceBean"); // 
            bean = (MediaService) ctx.lookup("java:global/MediaserverApp-ejb/MediaServiceBean!se.nrm.mediaserver.domain.MediaService");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
