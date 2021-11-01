package net.codejava;

import app.Recruiter;
import app.Student;
import database.Dao;
import database.Operations;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.google.gson.*;

@WebServlet("/home")
public class ShowAllStudentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShowAllStudentsServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ArrayList<Student> details = new ArrayList<Student>();
        Operations userDao=new Operations();


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

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
