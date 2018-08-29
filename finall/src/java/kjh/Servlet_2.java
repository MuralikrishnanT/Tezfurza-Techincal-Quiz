/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kjh;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
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
public class Servlet_2 extends HttpServlet {

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
         int n=0;
        int s=0;
        int max=6;
        int min=1;
       int mark=0;
        String a = null;
        String b=null;
        String c=null;
        String ans=null;
        String na=null;
        String qus=null;
        int qu=2;
       // int i=1;
        int j=1;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession();
            String name=(String)session.getAttribute("name");
            session.setAttribute("n1",name);
            out.println(name);
            ans=request.getParameter("A");
           String ans1=request.getParameter("s");
            out.println("oo"+ans1);
            out.println("first answer is"+ans);
           // int n1=(Integer)session.getAttribute("un");
            String oans=(String)session.getAttribute("d");
            out.println("final answer is"+oans);
            Random rand=new Random();
            n=rand.nextInt(max-min)+1;
            session.setAttribute("n",n);
            out.println(n);
           int i=(Integer)session.getAttribute("i");
           qus=request.getParameter("qu");
          // if(ans.equals("next")){
               //out.println("nn");
               
          // }
           //int k=(Integer)session.getAttribute("j");
          // out.println(k);
           // j=(Integer)session.getAttribute("j");
           
            try{
            Class.forName("com.mysql.jdbc.Driver");
                
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/cse","root","1234");
               
                    //out.println("connection established");
                    Statement st=con.createStatement();
                    //st.executeUpdate("insert into first values ('"+na+"')");
                    String sql ="SELECT * FROM first where sno='"+n+"' ;";
             ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    s=rs.getInt(1);
                    a=rs.getString(2);
                    b=rs.getString(3);
                    c=rs.getString(4);
                    out.println(a);
                    
                    
                }
                String s1="select*from id where id='"+name+"';";
                ResultSet rs1 = st.executeQuery(s1);
                while(rs1.next()){
                 na = rs1.getString(2);
                }
                
           
                String qus1="select*from ans1 where id='"+name+"';";
                ResultSet rs2 = st.executeQuery(qus1);
                while(rs2.next()){
                 qu = rs2.getInt(3);
                 out.println("qus is"+qu);
                         qu++;
                }
               
             
            
             }
            catch(Exception e){}
            
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
            out.println("margin-top=0.5db");
            out.println("margin-bottom=0.5db");
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
out.println("document.getElementById('ne').style.display=\'none\';");
out.println("}");
	out.println("function check(){");
	out.println("var countdownNumberEl = document.getElementById('countdown-number');");
out.println("var countdown = 15;");

out.println("countdownNumberEl.textContent = countdown;");

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
out.println("	document.getElementById('su').disabled = \'block\';");
out.println("	document.getElementById('ne').style.display = \'block\';");
	//alert("jd");
out.println("}");

out.println("}");
out.println("</script>");
out.println("<body onload=\"ok();\">");
	//out.println("<p>1.Who is the founder of 'AMAZON'?</p>");
//out.println("<input type=\"radio\" name=\"g\" id=\'m\'>Sundar Pichai<input type=\"radio\" name=\"g\" id=\'mk\'>Jeff Bezos");
//out.println("<input type=\"radio\" name=\"g\" id=\'mkk\'>John<input type=\"radio\" name=\"g\" id=\'mkkk\'>Michale Jackson<br/>");
out.println("<div id=\"countdown\">");
 out.println(" <div id=\"countdown-number\"></div>");

 out.println(" <svg>");
   out.println(" <circle r=\"18\" cx=\"20\" cy=\"20\" onload=\"check();\"></circle>");
 out.println(" </svg>");
out.println("</div>");

           // out.println("<body bgcolor=\"skyblue\">");
out.println("<div id=\"head\">");
            out.println("<center>"+"<b>"+"<h1>"+"TEZFUERZA18"+"</h1>"+"</b>"+"<center>");
            out.println("</div>");
            out.println("<div id=\"mkk\">");
            out.println("<center>"+"<h1>"+"id:"+name+"</h1>"+"</center>");
            out.println("</div>");
            out.println("<div class=\"mk\">");
            out.println("<h1>"+qu+":"+ a + "</h1>");
            
            //out.println(b);
            out.println("<form method='post' action='Servlet_3'>");
           // out.println(""+n);
            out.println("<input type=\"radio\" value="+b+" name=\"B\" id=\"m\" required>"+b);
            out.println("<input type=\"radio\" value="+c+" name=\"B\" id=\"mk\" required>"+c);
            out.println("<input type=\"submit\" value=\"submit\" onclick=\"Servlet_3.java\" id=\"su\" display=\"none\">");
            out.println("</form>");
            out.println("<form method='post' action='Servlet_6'>");
            out.println("<center><input type=\"submit\" value=\"next\" onclick=\"Servlet_6.java\" id=\"ne\"  name=\"s\"></center>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            out.println("original name"+name);
           // session.setAttribute("i",i);
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
