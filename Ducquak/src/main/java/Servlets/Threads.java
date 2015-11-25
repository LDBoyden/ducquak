/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Library.CassandraHosts;
import Library.Convertors;
import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Session;
/**
 *
 * @author arturpopov
 */
@WebServlet(name = "Threads", urlPatterns = {"/Threads"})
public class Threads extends HttpServlet {

        private Cluster cluster;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        }
    @Override
public void init(ServletConfig config) throws ServletException {

        cluster = CassandraHosts.getCluster();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String threadName = request.getParameter("threadname");
        String description = request.getParameter("description");
        String maxmembers = request.getParameter("maxmembers");
        if(maxmembers.compareTo("") == 0 || maxmembers.compareTo("0") == 0)
        {
            maxmembers = null;
        }
        Session s = cluster.connect("ducquak");
        Convertors convertor = new Convertors();
        java.util.UUID userID = convertor.getTimeUUID();
        PreparedStatement pS = s.prepare("INSERT INTO threads () Values (?,?,?)");
        BoundStatement boundStatement = new BoundStatement(pS);
        s.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        userID,username,Password));
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
