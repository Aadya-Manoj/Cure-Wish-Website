/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
public class BloodPressureCalculatorServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            int age = Integer.parseInt(request.getParameter("age"));
            String gender = request.getParameter("gender");
            int systolic = Integer.parseInt(request.getParameter("systolic"));
            int diastolic = Integer.parseInt(request.getParameter("diastolic"));
            String bloodPressureLevel = "";
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/curewish", "root", "aadya");
            PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into bloodpressure values(?,?,?,?)");
            ps.setInt(1, age);
            ps.setInt(2, systolic);
            ps.setInt(3, diastolic);
            ps.setString(4,gender);
            ps.executeUpdate();
            if (age < 18) {
                bloodPressureLevel = "N/A";
            } else if (age >= 18 && age <= 29) {
                if (gender.equalsIgnoreCase("male")) {
                    if (systolic < 108 || diastolic < 69) {
                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 108 && systolic <= 128) && (diastolic >= 69 && diastolic <= 84)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 129 && systolic <= 139) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 140 && systolic <= 159) || (diastolic >= 90 && diastolic <= 99)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                } else {
                    if (systolic < 102 || diastolic < 64) {
                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 102 && systolic <= 120) && (diastolic >= 64 && diastolic <= 80)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 121 && systolic <= 129) || (diastolic >= 81 && diastolic <= 84)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 130 && systolic <= 139) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                }
            } else if (age >= 30 && age <= 39) {
                if (gender.equalsIgnoreCase("male")) {
                    if (systolic < 109 || diastolic < 70) {
                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 109 && systolic <= 129) && (diastolic >= 70 && diastolic <= 84)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 130 && systolic <= 139) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 140 && systolic <= 159) || (diastolic >= 90 && diastolic <= 99)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                } else {
                    if (systolic < 100 || diastolic < 65) {

                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 100 && systolic <= 119) && (diastolic >= 65 && diastolic <= 80)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 120 && systolic <= 129) || (diastolic >= 81 && diastolic <= 84)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 130 && systolic <= 139) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                }
            } else if (age >= 40 && age <= 49) {
                if (gender.equalsIgnoreCase("male")) {
                    if (systolic < 110 || diastolic < 70) {
                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 110 && systolic <= 130) && (diastolic >= 70 && diastolic <= 84)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 131 && systolic <= 139) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 140 && systolic <= 159) || (diastolic >= 90 && diastolic <= 99)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                } else {
                    if (systolic < 102 || diastolic < 65) {
                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 102 && systolic <= 120) && (diastolic >= 65 && diastolic <= 80)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 121 && systolic <= 129) || (diastolic >= 81 && diastolic <= 84)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 130 && systolic <= 139) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                }
            } else if (age >= 50 && age <= 59) {
                if (gender.equalsIgnoreCase("male")) {
                    if (systolic < 110 || diastolic < 70) {
                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 110 && systolic <= 132) && (diastolic >= 70 && diastolic <= 84)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 133 && systolic <= 139) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 140 && systolic <= 159) || (diastolic >= 90 && diastolic <= 99)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                } else {
                    if (systolic < 102 || diastolic < 65) {
                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 102 && systolic <= 120) && (diastolic >= 60 && diastolic <= 78)) {
                    } else if ((systolic >= 121 && systolic <= 135) && (diastolic >= 65 && diastolic <= 80)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 136 && systolic <= 144) || (diastolic >= 81 && diastolic <= 84)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 145 && systolic <= 159) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                }
            } else {
                if (gender.equalsIgnoreCase("male")) {
                    if (systolic < 110 || diastolic < 70) {
                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 110 && systolic <= 136) && (diastolic >= 70 && diastolic <= 84)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 137 && systolic <= 144) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 145 && systolic <= 159) || (diastolic >= 90 && diastolic <= 99)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                } else {
                    if (systolic < 102 || diastolic < 65) {
                        bloodPressureLevel = "Low";
                    } else if ((systolic >= 102 && systolic <= 141) && (diastolic >= 65 && diastolic <= 80)) {
                        bloodPressureLevel = "Ideal";
                    } else if ((systolic >= 142 && systolic <= 144) || (diastolic >= 81 && diastolic <= 84)) {
                        bloodPressureLevel = "Normal";
                    } else if ((systolic >= 145 && systolic <= 159) || (diastolic >= 85 && diastolic <= 89)) {
                        bloodPressureLevel = "High normal";
                    } else {
                        bloodPressureLevel = "High";
                    }
                }
            }
            out.println("<h2>Blood Pressure Level: " + bloodPressureLevel + "</h2>");
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
