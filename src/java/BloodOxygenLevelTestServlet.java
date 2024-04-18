/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class BloodOxygenLevelTestServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {

            /* TODO output your page here. You may use following sample code. */
            String gender = request.getParameter("gender");
            int age = Integer.parseInt(request.getParameter("age"));
            int oxygenLevel = Integer.parseInt(request.getParameter("oxygenLevel"));
            int targetOxygenLevel;
            if (gender.equals("Male")) {
                if (age >= 1 && age <= 9) {
                    targetOxygenLevel = 94;
                } else if (age >= 10 && age <= 59) {
                    targetOxygenLevel = 95;
                } else {
                    targetOxygenLevel = 96;
                }
            } else {
                if (age >= 1 && age <= 9) {
                    targetOxygenLevel = 94;
                } else if (age >= 10 && age <= 59) {
                    targetOxygenLevel = 96;
                } else {
                    targetOxygenLevel = 97;
                }
            }
            String status;
            if (oxygenLevel >= targetOxygenLevel) {
                status = "normal";
            } else if (oxygenLevel >= targetOxygenLevel - 1) {
                status = "mild hypoxemia";
            } else if (oxygenLevel >= targetOxygenLevel - 2) {
                status = "moderate hypoxemia";
            } else if (oxygenLevel >= targetOxygenLevel - 3) {
                status = "severe hypoxemia";
            } else {
                status = "critical hypoxemia";
            }
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/curewish", "root", "aadya");
                PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into bloodoxygen values(?,?,?)");
                ps.setInt(1, age);
                ps.setInt(2, oxygenLevel);
                ps.setString(3, gender);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
//    out.println("<html>");
//    out.println("<head>");
//    out.println("<title>Blood Oxygen Level Test Results</title>");
//    out.println("</head>");
//    out.println("<body>");
//    out.println("<h1>Blood Oxygen Level Test Results</h1>");
//    out.println("<p>Your oxygen level: " + oxygenLevel + "</p>");
//    //out.println("<p>Your target oxygen level: " + targetOxygenLevel + "</p>");
//    out.println("<p>Your status: " + status + "</p>");
//    out.println("</body>");
//    out.println("</html>");
            out.println("Your oxygen level : " + targetOxygenLevel);
            out.println("<br>Your status : <br>" + status);
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
