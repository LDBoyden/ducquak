/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Library.CassandraHosts;
import Stores.LoggedInfo;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arturpopov
 */
@WebServlet(name = "MyThreads", urlPatterns = {"/MyThreads"})
public class MyThreads extends HttpServlet {

    private Cluster cluster;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        cluster = CassandraHosts.getCluster();
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
         HttpSession http_session = request.getSession();
        LoggedInfo lg = (LoggedInfo) http_session.getAttribute("LoggedIn");
        String username = lg.getUserName();
        
       Session cluster_session = cluster.connect("ducquak");
        PreparedStatement ps = cluster_session.prepare("SELECT * FROM userthreads WHERE userName = ?");
        
        BoundStatement boundStatement = new BoundStatement(ps);
          ResultSet rs = cluster_session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
          String threads = "";
           if (rs.isExhausted()) {
                System.out.println("No Thread returned");
                return;
            } else {
                for (Row row : rs) {
                    UUID thread = row.getUUID("threadID");
                    threads += thread;
                    
                    System.out.println(thread);
                }

                }
           request.setAttribute("threads", threads);
          RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
            rd.forward(request,response);
        //We are assuming this always works.  Also a transaction would be good here !
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
