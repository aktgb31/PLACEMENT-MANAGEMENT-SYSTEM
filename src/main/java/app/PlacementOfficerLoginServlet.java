package app;

import database.*;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


public class PlacementOfficerLoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int password = Integer.parseInt(request.getParameter("password"));

        try {
            int user = Operations.placementOfficerLogin(userId, password);
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
            System.out.println(e);
        }
    }
}


