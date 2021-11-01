<%--
  Created by IntelliJ IDEA.
  User: mishr
  Date: 01-11-2021
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.io.*,java.util.*" %>
<html>
<head>
    <title>Student Home Page</title>
</head>
<body>
<h1>Student Home Page</h1>
    <h2>HTTP Header Request Example</h2>

    <table width = "100%" border = "1" align = "center">
        <tr bgcolor = "#949494">
            <th>Header Name</th>
            <th>Header Value(s)</th>
        </tr>
        <%
            Enumeration headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()) {
                String paramName = (String)headerNames.nextElement();
                out.print("<tr><td>" + paramName + "</td>\n");
                String paramValue = request.getHeader(paramName);
                out.println("<td> " + paramValue + "</td></tr>\n");
            }
        %>
    </table>
</body>
</html>
