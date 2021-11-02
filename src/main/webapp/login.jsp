<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Student</title>
</head>
<body>
<form action="LoginStudent"  method="POST">
    <h2 style="text-align: center;">Login as Student</h2>
    <table style="  margin-left: auto; margin-right:auto;">
        <tr>
            <td><label for="registerNo">Register No.</label></td>
            <td>: <input name="registerNo" type="text" id="registerNo" required></td>
        </tr>
        <tr>
            <td><label for="password">Password</label></td>
            <td>: <input name="password" id="password" type="password" required></td>
        </tr>
        <tr>
            <td></td>
            <td><input style="float: left;" type="reset"> <input style="float: right;" type="submit" name="submit"
                                                                 value="Submit"></td>
        </tr>
    </table>
</form>
</form>
</body>
</html>
