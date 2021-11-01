package net.codejava;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/home")
public class ShowAllStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShowAllStudentsServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        List<String> details = new ArrayList<String>();
        UserDAO userDao = new UserDAO();




        try {
            //Connection user = userDao.addStudent(name,registerNo,email,phoneNo,cgpa, placementStatus,placedIn,password);
            details=userDao.getAllStudents();
            Gson gson = new Gson();

            String userJSON = gson.toJson(details);
            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            printWriter.write(userJSON);
            printWriter.close();
            String destPage = "showstudents.jsp";

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new ServletException(ex);
        }
    }
}
