/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author Jorda
 */
public class SignupServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String username = "test";
    private final String password = "test";
    private final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    private final String DB_URL="jdbc:mysql://localhost:3306/vsdb";
    //  Database credentials
    private final String USER = "admin";
    private final String PASS = "admin";
    
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
            throws ServletException, IOException
    {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String uname = request.getParameter("username");
        String pwd = request.getParameter("password");
        String pwd2 = request.getParameter("psw");
        String email = request.getParameter("email");
        
        //If entered password don't match, return
        if(!(pwd.equals(pwd2)))
            response.sendRedirect("signup.jsp");
        
        try{
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         Statement stmt = conn.createStatement();
         String sql = "INSERT INTO player(username, password, email, fname,"
                 + " lname, referee) VALUES ('" + uname + "', '" + pwd + "', '" + email
                 + "', '" + fname + "', '" + lname + "', 0)";
         int rs = stmt.executeUpdate(sql);
         
         if(rs != 0) //Query Worked
         {
             Cookie cookie = new Cookie("username", uname);
            // setting cookie to expire in 60 mins
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
            response.sendRedirect("index2.jsp");
         }
         else
             // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Failed to create account. Please try again.";
      String docType =
        "<!doctype html public \"-//w3c//dtd html 4.0 " +
         "transitional//en\">\n";
         out.println(docType +
         "<html>\n" +
         "<head><title>" + title + "</title></head>\n" +
         "<body bgcolor=\"#f0f0f0\">\n" +
         "<h1 align=\"center\">" + title + "</h1>\n");
         
         

         
        

         // Clean-up environment
         stmt.close();
         conn.close();
      }catch(SQLException se){
         //Handle errors for JDBC
         se.printStackTrace();
      }catch(Exception e){
         //Handle errors for Class.forName
         e.printStackTrace();
      }
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
