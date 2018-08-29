/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kjh;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.Random;

/**
 *
 * @author hp
 */
public class Servlet_1 extends HttpServlet {

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
            throws ServletException, IOException ,NullPointerException{
        response.setContentType("text/html;charset=UTF-8");
       // String name=null;
       // String name1=null;
        int n=0;
        int s=0;
        int max=6;
        int min=1;
        String a = null;
        String b=null;
        String c=null;
        String d=null;
        String na=null;
        int i=1;
        int j=0;
        String all=null;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name=request.getParameter("name");
           // out.println(name);
                HttpSession session=request.getSession();
            session.setAttribute("name",name);
            session.setAttribute("i",i);
            session.setAttribute("j",j);
            //String name1=(String)session.getAttribute("n1");
            Random rand=new Random();
            n=rand.nextInt(max-min)+1;
            out.println("random"+n);
            
            try{
            Class.forName("com.mysql.jdbc.Driver");
                
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cse","root","1234");
               
                    //out.println("connection established");
                    Statement st=con.createStatement();
                    String sq="Select*from ans1 where id='"+name+"';";
                    ResultSet rs1=st.executeQuery(sq);
                    while(rs1.next()){
                    all=rs1.getString(1);
                    out.println(all);
                    }
                    /*if(!(all.equals(name))){
                        out.println(all);
                    out.println("success");
                    }*/
                   
                    out.println(all);
                   
                    //st.executeUpdate("insert into first values ('"+na+"')")
                    String sql ="SELECT * FROM first where sno='"+n+"' ;";
             ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    s=rs.getInt(1);
                    a=rs.getString(2);
                    b=rs.getString(3);
                    c=rs.getString(4);
                    d=rs.getString(5);
                   // out.println(d);
                }
                
                /* if(all.equals(name)){
                        //out.println(all);
                    out.println("no");
                }*/
                    //HttpSession session=request.getSession();
                    //session.setAttribute("id",uname);
                
                String s1="select*from id where id='"+name+"';";
                ResultSet rs2 = st.executeQuery(s1);
                while(rs2.next()){
                 na = rs2.getString(2);
                }
                  // }
            }
            catch(Exception e){}
            try{
                 
           /* if(name.equals(na)){
                
               name="123";
               out.println("if name"+name);
              // request.getRequestDispatcher("/Servlet_2").forward(request, response);
            }*/
            
            }catch(NullPointerException e){
            out.println(e);
            }
           //try{
             out.println("<!DOCTYPE html>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet1</title>");            
            out.println("</head>");
            out.println("<style type=\"text/css\">");
            out.println(".mk{");
            out.println("text-align: center;");
            out.println("font-weight: bold;");
            out.println("}");
            out.println("#mkk{");
            out.println("text-align: center;");
            out.println("font-weight: bold;");
            out.println("}");
            out.println("#head{");
            out.println("margin-top:-40px;");
            out.println("}");
           // out.println("</style>");
           // out.println("<style type=\"text/css\">");
	out.println("body {");
 out.println(" height: 100%;");
out.println("  width: 100%;");
  out.println("background-color: #333;");
out.println("}");

out.println("#countdown {");
 out.println(" position: relative;");
 out.println(" margin: auto;");
out.println("  margin-top: 100px;");
 out.println(" height: 40px;");
 out.println(" width: 40px;");
 out.println(" text-align: center;");
out.println("}");
out.println("#mkk{");
out.println("margin-right:-1000px;");
out.println("}");
out.println(".mk{");
out.println("margin-top:100px;");
out.println("}");
out.println("#sub{");
out.println("margin-bottom:150px;");
out.println("}");
out.println("#countdown-number {");
out.println("  color: white;");
 out.println(" display: inline-block;");
 out.println(" line-height: 40px;");
out.println("}");

out.println("svg {");
 out.println(" position: absolute;");
 out.println(" top: 0;");
out.println("  right: 0;");
 out.println(" width: 40px;");
 out.println(" height: 40px;");
out.println("  transform: rotateY(-180deg) rotateZ(-90deg);");
out.println("}");

out.println("svg circle {");
 out.println(" stroke-dasharray: 113px;");
 out.println(" stroke-dashoffset: 0px;");
 out.println(" stroke-linecap: round;");
out.println("  stroke-width: 2px;");
 out.println(" stroke: white;");
out.println("  fill: none;");
out.println("  animation: countdown 10s linear infinite forwards;");
out.println("}");

out.println("@keyframes countdown {");
  out.println("from {");
  out.println("  stroke-dashoffset: 0px;");
 out.println(" }");
  out.println("to {");
  out.println("  stroke-dashoffset: 113px;");
 out.println(" }");
out.println("}");
out.println("</style>");
out.println("<script type=\"text/javascript\">");
out.println("function ok(){");
out.println("document.getElementById('ne').style.display=\'block\';");
out.println("}");
	out.println("function check(){");
        
       // out.println("document.getElementById('ne').style.display=\'none\';");
	out.println("var countdownNumberEl = document.getElementById('countdown-number');");
out.println("var countdown = 15;");

out.println("countdownNumberEl.textContent = countdown;");
//out.println("document.getElementById('ne').style.display=\'none\';");
out.println("setInterval(function() {");
 out.println(" countdown = --countdown <= 0 ? 0 : countdown;");
out.println("if(countdown==0){");
	out.println("vis();");
out.println("}");
out.println(" countdownNumberEl.textContent = countdown;");
out.println("}, 1000);");
out.println("function vis(){");
	out.println("clearTimeout(countdown)");
out.println("	countdown=0;");
	out.println("document.getElementById('m').disabled = \'disabled\';");
out.println("	document.getElementById('mk').disabled = \'disabled\';");
out.println("	document.getElementById('su').disabled=\'block\';");
out.println("	document.getElementById('ne').style.display=\'block\';");
	//alert("jd");
out.println("}");

out.println("}");
out.println("</script>");
out.println("<body onload=\"ok();\">");
out.println("<div id=\"head\">");
out.println("<center>"+"<b>"+"<h1>"+"TEZFUERZA18"+"</h1>"+"</b>"+"<center>");
out.println("<center>"+"<b>"+"<h1>"+"BATTLE OF BRAINS"+"</h1>"+"</b>"+"<center>");
out.println("</div>");
out.println("<div id=\"mkk\">");
            out.println("<center>"+"<h1>"+"id:"+name+"</h1>"+"</center>");
            out.println("</div>");
            out.println("<div class=\"mk\">");
            out.println("<h1>"+i+":"+ a + "</h1>");
            
            //out.println(b);
            out.println("<form method='post' action='Servlet_5'>");
           // out.println(""+n);
            out.println("<input type=\"radio\" value="+b+" name=\"A\" id=\"m\" required>"+b+"&nbSsp"+"&nbsp"+"&nbsp"+"&nbsp");
            out.println("<input type=\"radio\" value="+c+" name=\"A\" id=\"mk\" required>"+c+"<br><br>");
            out.println("<input type=\"submit\" value=\"submit\" onclick=\"Servlet_5.java\" id=\"su\" display=\"visible\" name=\"sa\">");
            out.println("</form>");
            out.println("<form method='post' action='Servlet_4'>");
            out.println("<div id=\"sub\">");
            out.println("<center><input type=\"submit\" value=\"next\" onclick=\"Servlet_4.java\" id=\"ne\"  name=\"s\"></center>"+"&nbsp"+"&nbsp");
            out.println("</div>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
	
out.println("<div id=\"countdown\">");
 out.println(" <div id=\"countdown-number\"></div>");

 out.println(" <svg>");
   out.println(" <circle r=\"18\" cx=\"20\" cy=\"20\" onload=\"check();\"></circle>");
 out.println(" </svg>");
out.println("</div>");

           // out.println("<body bgcolor=\"skyblue\">");
            
            
            out.println("</body>");
            out.println("</html>");
           // out.println("name1 val"+name1);
            //String name2=(String)session.getAttribute("n2");
            //session.setAttribute("un",n);
             session.setAttribute("d",d);
           // out.println(name2);
           // String name3=(String)request.getAttribute("uname");
           // out.println(name3);
            
            
           // else{
               // out.println("wrong");
            //}
            //out.println(name);
             
           //}catch(Exception e){
           //out.println(e);
           //}
        }
     // System.out.println(name);
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
