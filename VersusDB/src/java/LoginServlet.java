/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.naming.*;

/**
 *
 * @author Jordan Laing
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private static final long serialVersionUID = 1L;
    private final String username = "test";
    private final String password = "test";
    private final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    private final String DB_URL="jdbc:mysql://localhost:3306/vsdb";
    //  Database credentials
    private final String USER = "admin";
    private final String PASS = "admin";
      
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {

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
            throws ServletException, IOException
    {
//        try{
//         // Register JDBC driver
//         Class.forName(JDBC_DRIVER);
//
//         // Open a connection
//         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//         // Execute SQL query
//         Statement stmt = conn.createStatement();
//         String sql;
//         sql = "SELECT id, username, password FROM player";
//         ResultSet rs = stmt.executeQuery(sql);
//
//         // Extract data from result set
//         while(rs.next()){
//            //Retrieve by column name
//            int id  = rs.getInt("id");
//            String user = rs.getString("username");
//            String pass = rs.getString("password");
//
//            //Display values
//            out.println("ID: " + id + "<br>");
//            out.println(", Username: " + user + "<br>");
//            out.println(", Password: " + pass + "<br>");
//         }
//         out.println("</body></html>");
//
//         // Clean-up environment
//         rs.close();
//         stmt.close();
//         conn.close();
//      }catch(SQLException se){
//         //Handle errors for JDBC
//         se.printStackTrace();
//      }catch(Exception e){
//         //Handle errors for Class.forName
//         e.printStackTrace();
//      }
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
        String uname = request.getParameter("username");
        String pwd = request.getParameter("password");
        boolean loggedIn = true;
        
        try{
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         Statement stmt = conn.createStatement();
         String sql = "SELECT username, password FROM player";
         ResultSet rs = stmt.executeQuery(sql);
         String user = "";
         String pass = "";

         // Extract data from result set
         while(rs.next()){
            //Retrieve by column name
            user = rs.getString("username");
            pass = rs.getString("password");

            //Check if matches input
            if(user.equals(uname) && pass.equals(pwd))
            {
                Cookie cookie = new Cookie("username", uname);
                // setting cookie to expire in 60 mins
                cookie.setMaxAge(60 * 60);
                response.addCookie(cookie);
                response.sendRedirect("index2.jsp");
            }            
         }
         if(!(user.equals(uname) && pass.equals(pwd)))
         {
             response.sendRedirect("login.jsp");
         }
        

         // Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      }catch(SQLException se){
         //Handle errors for JDBC
         se.printStackTrace();
      }catch(Exception e){
         //Handle errors for Class.forName
         e.printStackTrace();
      }
        
        
 
//        if (username.equals(uname) && password.equals(pwd)) {
//            Cookie cookie = new Cookie("username", uname);
//            // setting cookie to expire in 60 mins
//            cookie.setMaxAge(60 * 60);
//            response.addCookie(cookie);
//            response.sendRedirect("index2.html");
//        } else {
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
//            PrintWriter out = response.getWriter();
//            out.println("<font color=red>Please make sure you enter UserID/Pass as \"CrunchifyUser : CrunchifyPassword\".</font>\n");
//            loggedIn = false;
//            String fail = "Invalid username or password.";
//            request.setAttribute("fail", fail);
//            response.sendRedirect("login.jsp");
//        }
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
