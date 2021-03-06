package app;

import database.*;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


public class AddRecruiterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String ctc = request.getParameter("ctc");
        String duration = request.getParameter("duration");
        String location = request.getParameter("location");
        Recruiter details = new Recruiter();
        details.setName(name);
        details.setCtc(ctc);
        details.setRole(role);
        details.setLocation(location);
        details.setDuration(duration);

        try {
            int user = Operations.addRecruiter(details);
            String destPage = "recruiter.jsp";

            if (user != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "placement_home.jsp";

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