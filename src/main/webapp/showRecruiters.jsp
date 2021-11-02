<%@ page import="app.Recruiter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Recruiters</title>
</head>

<body style="text-align: center">
<h2>All Availaible Recruiters</h2>
<table style="text-align: center; border: 1px solid black;  border-collapse: collapse; margin-left: auto;  margin-right: auto; width: 50%;">
    <tr>
        <th>RecruiterId</th>
        <th>Name</th>
        <th>Role</th>
        <th>Ctc</th>
        <th>Location</th>
        <th>Duration</th>
    </tr>
    <%
        try {
            ArrayList<Recruiter> details = Operations.getAllRecruiters();
            for (int i = 0; i < details.size(); i++) {
                out.print("<tr>");
                out.print("<td>" + details.get(i).getRecruiterId() + "</td>");
                out.print("<td>" + details.get(i).getName() + "</td>");
                out.print("<td>" + details.get(i).getRole() + "</td>");
                out.print("<td>" + details.get(i).getCtc() + "</td>");
                out.print("<td>" + details.get(i).getLocation() + "</td>");
                out.print("<td>" + details.get(i).getDuration() + "</td>");
                out.print("</tr>");
            }
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    %>
</table>
<form action="RemoveRecruiter"  method="POST">
    <h2 style="text-align: center;">Remove a Recruiter</h2>
    <table style="  margin-left: auto; margin-right:auto;">
        <tr>
            <td><label for="recruiterId">User Id</label></td>
            <td>: <input name="recruiterId" type="number" id="recruiterId" required></td>
        </tr>
            <td></td>
            <td><input style="float: left;" type="reset"> <input style="float: right;" type="submit" name="submit"
                                                                 value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>
