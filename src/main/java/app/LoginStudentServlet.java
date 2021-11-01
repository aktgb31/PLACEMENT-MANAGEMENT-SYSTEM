package app;

import database.*;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class LoginStudentServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rollNo = request.getParameter("registerNo");
        String password = request.getParameter("password");
        try {
            int user = Operations.studentLogin(rollNo, password);
            String destPage = "login.jsp";
            if (user != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "student_home.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

