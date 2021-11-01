package net.codejava;

import app.Recruiter;
import app.Student;
import com.mysql.jdbc.Connection;
import database.Dao;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class UserSignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserSignupServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String registerNo = request.getParameter("registerNo");
        String email = request.getParameter("email");
        String phoneNo = request.getParameter("phoneNo");
        float cgpa = Float.parseFloat(request.getParameter("cgpa"));
        String placementStatus = "NULL";

        String placedIn = "NULL";
        String password = request.getParameter("password");
        Student details = new Student();
        Dao userDao=new Dao();
        details.setName(name);
        details.setEmail(email);
        details.setCgpa(cgpa);
        details.setPassword(password);
        details.setPlacementStatus(placementStatus);
        details.setPhoneNo(phoneNo);
        details.setRegisterNo(registerNo);
        details.setPlacedIn(placedIn);
        try {
            Connection user = userDao.addStudent(details);
            String destPage = "register.jsp";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "login.jsp";
            } else {
                String message = "Fill Details correctly";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
