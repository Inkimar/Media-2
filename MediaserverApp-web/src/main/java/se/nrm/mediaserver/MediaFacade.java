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
@WebServlet(name = "Save", urlPatterns = {"/Save"})
public class MediaFacade extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        MediaService service = this.outreach();
        Media media = new Image();
        media.setFilename("Butterfly-8Maj-kl1525.jpg");
        media.setOwner("Larssons");
        service.save(media);
       
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>MediaFacade :: 15:57</title>");
            out.println("<h1>16:21 Testing at " + service.test() + "</h1>");
            out.println("</head>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    private MediaService outreach() {
        MediaService bean = null;
        try {
            Properties jndiProps = new Properties();
            jndiProps.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.10.139");
            Context ctx = new InitialContext(jndiProps);
            bean = (MediaService) ctx.lookup("java:global/MediaserverApp-ejb/MediaServiceBean"); // 


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
