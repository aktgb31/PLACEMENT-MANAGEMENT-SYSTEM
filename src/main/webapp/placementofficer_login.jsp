<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Placement Officer</title>
</head>
<body>
<form action="LoginPlacementOfficer"  method="POST">
    <h2 style="text-align: center;">Login as Placement Officer</h2>
    <table style="  margin-left: auto; margin-right:auto;">
        <tr>
            <td><label for="userId">User Id</label></td>
            <td>: <input name="userId" type="number" id="userId" required></td>
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
</body>
</html>
