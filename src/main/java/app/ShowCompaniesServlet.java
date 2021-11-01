package app;

import app.Recruiter;
import database.Dao;
import database.Operations;
import com.google.gson.*;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

public class ShowCompaniesServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ArrayList<Recruiter> details = new ArrayList<Recruiter>();
        Operations userDao = new Operations();


        try {
            //Connection user = userDao.addStudent(name,registerNo,email,phoneNo,cgpa, placementStatus,placedIn,password);
            details = userDao.getAllRecruiters();
            Gson gson = new Gson();

            String userJSON = gson.toJson(details);
            PrintWriter printWriter = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            printWriter.write(userJSON);
            printWriter.close();
            String destPage = "showRecruiters.jsp";

            RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
            dispatcher.forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
