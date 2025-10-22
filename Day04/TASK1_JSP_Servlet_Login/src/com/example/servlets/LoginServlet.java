package com.example.servlets;

import com.example.utils.DBUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE (email = ? OR username = ?) AND password = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, username);
                ps.setString(3, password); // NOTE: passwords are plain-text in this sample
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        request.getSession().setAttribute("user", rs.getString("username"));
                        response.sendRedirect("welcome.jsp");
                        return;
                    } else {
                        request.setAttribute("message", "Incorrect email or password.");
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
