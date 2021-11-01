package net.codejava;

import app.Recruiter;
import com.mysql.jdbc.Connection;
import database.Dao.*;
import database.Operations;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addrecruiter")
public class AddRecruiterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddRecruiterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String ctc = request.getParameter("ctc");
        String duration = request.getParameter("duration");

        String location = request.getParameter("location");

        Operations userDao=new Operations();
        Recruiter details = new Recruiter();
        details.setName(name);
        details.setCtc(ctc);
        details.setRole(role);
        details.setLocation(location);
        details.setDuration(duration);

        try {
            int user = userDao.addRecruiter(details);
            String destPage = "placement_home.jsp";

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
            throw new ServletException(e);
        }
    }
}