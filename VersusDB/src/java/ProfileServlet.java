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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jorda
 */
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String username = "test";
    private final String password = "test";
    private final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    private final String DB_URL="jdbc:mysql://localhost:3306/vsdb";
    //  Database credentials
      final String USER = "admin";
      final String PASS = "admin";
      
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
            throws ServletException, IOException
    {
        // get current session, or initialise one if none
        HttpSession sess = request.getSession(true);
        
        String userName = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                userName = cookie.getValue();
            }
        }
        
        try{
         // Register JDBC driver
         Class.forName(JDBC_DRIVER);

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

         // Execute SQL query
         Statement stmt = conn.createStatement();
         String sql = "SELECT username, fname, lname, id, team FROM player WHERE username='"+userName+"'";
         ResultSet rs = stmt.executeQuery(sql);
         String user = "";
         String pass = "";
         
        // Extract data from result set, should be 1 row
        if(rs.next()){
           String fname = rs.getString("fname");
           String lname = rs.getString("lname");
           int id = rs.getInt("id");
           String team = rs.getString("team");

           sess.setAttribute("fname", fname);
           sess.setAttribute("lname", lname);
           sess.setAttribute("id", id);
           sess.setAttribute("team", team);
           
           Cookie cookie1 = new Cookie("fname", fname);
           response.addCookie(cookie1);
           Cookie cookie2 = new Cookie("lname", lname);
           response.addCookie(cookie2);
           Cookie cookie3 = new Cookie("team", team);
           response.addCookie(cookie3);
           Cookie cookie4 = new Cookie("id", String.valueOf(id));
           response.addCookie(cookie4);
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
        response.sendRedirect("profile.jsp");
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
