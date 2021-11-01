package app;

import database.*;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login_p")
public class PlacementOfficerLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PlacementOfficerLoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int password = Integer.parseInt(request.getParameter("password"));

        Operations userDao=new Operations();

        try {
            int user = userDao.placementOfficerLogin(userId, password);
            String destPage = "placementofficer_login.jsp";

            if (user != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                destPage = "placement_home.jsp";
            } else {
                String message = "Invalid email/password";
                request.setAttribute("message", message);
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}


