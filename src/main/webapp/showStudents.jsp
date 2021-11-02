<%@ page import="app.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="database.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show All Students</title>
</head>

<body style="text-align: center">
<h2>Students Registered for Placement</h2>
<table style="text-align: center; border: 1px solid black;  border-collapse: collapse; margin-left: auto;  margin-right: auto; width: 50%;">
    <tr>
        <th>Register No</th>
        <th>Name</th>
        <th>Email</th>
        <th>Phone No</th>
        <th>Cgpa</th>
        <th>Placement Status</th>
        <th>Placed In</th>
    </tr>
    <%
        try {
            ArrayList<Student> details = Operations.getAllStudents();
            for (int i = 0; i < details.size(); i++) {
                out.print("<tr>");
                out.print("<td>" + details.get(i).getRegisterNo() + "</td>");
                out.print("<td>" + details.get(i).getName() + "</td>");
                out.print("<td>" + details.get(i).getEmail() + "</td>");
                out.print("<td>" + details.get(i).getPhoneNo() + "</td>");
                out.print("<td>" + details.get(i).getCgpa() + "</td>");
                out.print("<td>" + details.get(i).getPlacementStatus() + "</td>");
                out.print("<td>" + details.get(i).getPlacedIn() + "</td>");
                out.print("</tr>");
            }
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    %>
</table>
</body>
</html>
