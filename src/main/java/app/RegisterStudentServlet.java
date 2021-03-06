package app;
import database.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class RegisterStudentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String registerNo = request.getParameter("registerNo");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");
        float cgpa = Float.parseFloat(request.getParameter("cgpa"));
        String password = request.getParameter("password");
        Student details = new Student();
        details.setName(name);
        details.setEmail(email);
        details.setCgpa(cgpa);
        details.setPassword(password);
        details.setPhoneNo(phoneNo);
        details.setRegisterNo(registerNo);
        details.setPlacementStatus("NOT PLACED");
        try {
            int user = Operations.addStudent(details);
            System.out.println(user);
            String destPage = "register.jsp";

            if (user != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "login.jsp";
            } else {
                String message = "Fill Details correctly";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
