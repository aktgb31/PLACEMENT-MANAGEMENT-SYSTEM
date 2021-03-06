package app;

import database.*;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


public class ApplyforCompanyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ApplyforCompanyServlet() {
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String StudentID = request.getParameter("registerNo");
        int recruiterId = Integer.parseInt(request.getParameter("recruiterId"));
        Application details = new Application();
        details.setStudentId(StudentID);
        details.setRecruiterId(recruiterId);


        Operations userDao=new Operations();

        try {
            int user = userDao.studentAppliesForCompany(details);
            String destPage = "home_s.jsp";

            if (user != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

            } else {
                String message = "Error";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}