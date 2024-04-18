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
public class CholesterolTestCalculatorServlet extends HttpServlet {

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
            int age = Integer.parseInt(request.getParameter("age"));
            int total = Integer.parseInt(request.getParameter("total"));
            int hdl = Integer.parseInt(request.getParameter("hld"));
            int riskRatio = total / hdl;
//
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Cholesterol Test Results</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Cholesterol Test Results</h1><br>");
//
//            out.println(" Total Cholesterol: " + total + " <");
//            out.println(" HDL Cholesterol: " + hdl + " ");
//            out.println(" Age: " + age + " ");

            out.println(" Risk Ratio: " + riskRatio + " <br>");
            if (age < 20) {
                out.println(" Your risk level cannot be calculated because you are under 20 years old. <br>");
            } else if (age >= 20 && age < 30) {
                if (riskRatio < 3) {
                    out.println(" Your risk level is low. <br>");
                } else if (riskRatio >= 3 && riskRatio < 5) {
                    out.println(" Your risk level is moderate. <br>");
                } else {
                    out.println(" Your risk level is high. ,br>");
                }
            } else if (age >= 30 && age < 40) {
                if (riskRatio < 4) {
                    out.println(" Your risk level is low. ");
                } else if (riskRatio >= 4 && riskRatio < 7) {
                    out.println(" Your risk level is moderate. <br>");
                } else {
                    out.println(" Your risk level is high. <br>");
                }
            } else if (age >= 40 && age < 50) {
                if (riskRatio < 5) {
                    out.println(" Your risk level is low. <br>");
                } else if (riskRatio >= 5 && riskRatio < 9) {
                    out.println(" Your risk level is moderate. <br>");
                } else {
                    out.println(" Your risk level is high. <br>");
                }
            } else if (age >= 50 && age < 60) {
                if (riskRatio < 6) {
                    out.println(" Your risk level is low. <br>");
                } else if (riskRatio >= 6 && riskRatio < 11) {
                    out.println(" Your risk level is moderate. <br>");
                } else {
                    out.println(" Your risk level is high. <br>");
                }
            } else {
                if (riskRatio < 7) {
                    out.println(" Your risk level is low. <br>");
                } else if (riskRatio >= 7 && riskRatio < 14) {
                    out.println(" Your risk level is moderate. <br>");
                } else {
                    out.println(" Your risk level is high. <br>");
                }
            }
//            out.println("</body>");
//            out.println("</html>");
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/curewish", "root", "aadya");
                PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into cholesterol values(?,?,?)");
                ps.setInt(1, age);
                ps.setInt(2, total);
                ps.setInt(3, hdl);
                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
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
