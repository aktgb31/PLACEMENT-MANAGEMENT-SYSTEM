package net.codejava;

import java.io.*;
import java.sql.SQLException;

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


        UserDAO userDao = new UserDAO();

        try {
            Connection user = userDao.addRecruiter(name,role,ctc,duration,location);
            String destPage = "placement_home.jsp";

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

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