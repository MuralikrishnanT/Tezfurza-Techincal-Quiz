/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class Servlet_4 extends HttpServlet {

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
        String ans=null;
        String ans1=null;
        int mark=0;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ans=request.getParameter("A");
            ans1=request.getParameter("s");
            HttpSession session=request.getSession();
            String name=(String)session.getAttribute("name");
            String oans=(String)session.getAttribute("d");
            int i=(Integer)session.getAttribute("i");
             try{
            Class.forName("com.mysql.jdbc.Driver");
                
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cse","root","1234");
               
                    //out.println("connection established");
                    Statement st=con.createStatement();
                    if(ans1.equals("next")){
                        mark=mark+0;
                        st.executeUpdate("insert into ans1 values ('"+name+"','"+mark+"','"+i+"')");
                        request.getRequestDispatcher("/Servlet_2").forward(request, response);
                  // out.println("no");
                    }
                   
                    if(ans.equals(oans)){
                     mark=mark+1;
                     ans=null;
                      st.executeUpdate("insert into ans1 values ('"+name+"','"+mark+"','"+i+"')");
                      out.println("inserted");
                    oans=null;
             
            // qu++;
                      }
            else{
              mark=mark+0;
              st.executeUpdate("insert into ans1 values ('"+name+"','"+mark+"','"+i+"')");
             // qu++;
            }
             
                    
                     request.getRequestDispatcher("/Servlet_2").forward(request, response);
             }catch(Exception e){}
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet_4 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
