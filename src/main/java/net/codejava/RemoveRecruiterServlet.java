package net.codejava;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/removerecruiter")
public class RemoveRecruiterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RemoveRecruiterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int recruiterid = Integer.parseInt(request.getParameter("recruiterId"));


        UserDAO userDao = new UserDAO();

        try {
            Connection user = userDao.removeRecruiter(recruiterid);
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