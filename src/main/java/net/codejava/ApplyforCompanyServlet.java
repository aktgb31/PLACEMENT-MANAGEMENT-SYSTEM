package net.codejava;

import com.mysql.jdbc.Connection;
import database.Dao;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/apply")
public class ApplyforCompanyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ApplyforCompanyServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String StudentID = request.getParameter("registerNo");
        int recruiterId = Integer.parseInt(request.getParameter("recruiterId"));



        Dao userDao=new Dao();

        try {
            Connection user = userDao.studentAppliesForCompany(StudentID,recruiterId);
            String destPage = "home_s.jsp";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

            } else {
                String message = "Error";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}