package net.codejava;

import java.io.*;
import java.sql.SQLException;

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


        UserDAO userDao = new UserDAO();

        try {
            Connection user = userDao.addStudent(name,registerNo,email,phoneNo,cgpa, placementStatus,placedIn,password);
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
