package app;

import app.*;
import database.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


public class RemoveRecruiterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int recruiterid = Integer.parseInt(request.getParameter("recruiterId"));

        Recruiter details = new Recruiter();
        details.setRecruiterId(recruiterid);
        try {
            int user = Operations.removeRecruiter(details);
            String destPage = "showRecruiters.jsp";

            if (user != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

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