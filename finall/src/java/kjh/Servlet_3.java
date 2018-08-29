/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kjh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 *
 * @author hp
 */
public class Servlet_3 extends HttpServlet {

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
        int i=5;
        String c=null;
        int cc=0;
        int qus=0;
        int mark=0;
        int j=1;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession();
            String name=(String)session.getAttribute("n1");
            out.println(name);
             int n=(Integer)session.getAttribute("n");
             String ans=request.getParameter("B");
             //j=(Integer)session.getAttribute("i");
            try{
            Class.forName("com.mysql.jdbc.Driver");
                
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cse","root","1234");
               
                    //out.println("connection established");
                    Statement st=con.createStatement();
                    //st.executeUpdate("insert into first values ('"+na+"')");
                    String sql ="SELECT * FROM first where sno='"+n+"' ;";
             ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    c=rs.getString(5);
                    out.println(c);
                    
                    //HttpSession session=request.getSession();
                    //session.setAttribute("id",uname);
                }
                String sql1 ="SELECT * FROM ans1 where id='"+name+"' ;";
             ResultSet rs1 = st.executeQuery(sql1);
                while(rs1.next()){
                    cc=rs1.getInt(2);
                    qus=rs1.getInt(3);
                    out.println(cc);
                    
                    //HttpSession session=request.getSession();
                    //session.setAttribute("id",uname);
                
                }
           
            
            if(ans.equals(c)){
              cc=cc+1;
              qus=qus+1;
              st.executeUpdate("update ans1 set mark='"+cc+"'  where id='"+name+"'  ; ");
              st.executeUpdate("update ans1 set noofquestion='"+qus+"'  where id='"+name+"'  ; ");
              //out.println(mark);
              j++;
            }
            else{
           cc=cc+0;
           qus=qus+1;
                st.executeUpdate("update ans1 set mark='"+cc+"'  where id='"+name+"'  ; ");
                st.executeUpdate("update ans1 set noofquestion='"+qus+"'  where id='"+name+"'  ; ");
                j++;
            }
           /* if(name.equals("123")){
                
               name="123";
               out.println("if name"+name);
               session.setAttribute("n2",name);
               session.setAttribute("i",i);
               request.getRequestDispatcher("/Servlet_2").forward(request, response);
            }*/
            if(qus<5){
             request.getRequestDispatcher("/Servlet_2").forward(request, response);
            }
            else{
               request.getRequestDispatcher("final.html").forward(request, response);
            }  
            //}
             }
            catch(Exception e){}
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet_3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<input type=\"text\" name=\"qu\" value="+qus);
            out.println("<h1>Servlet Servlet_3 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            session.setAttribute("j",j);
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
