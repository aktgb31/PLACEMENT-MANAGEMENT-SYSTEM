
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recruiter</title>
</head>
<body style="text-align: center">
<form action="AddRecruiter"  method="POST">
    <h2 style="text-align: center;">Add a Recruiter</h2>
    <table style="  margin-left: auto; margin-right:auto;">
        <tr>
            <td><label for="name">Name</label></td>
            <td>: <input name="name" type="text" id="name" required></td>
        </tr>
        <tr>
            <td><label for="role">Role</label></td>
            <td>: <input name="role" id="role" type="text" required></td>
        </tr>
        <tr>
            <td><label for="ctc">CTC</label></td>
            <td>: <input name="ctc" id="ctc" type="text" required></td>
        </tr>
        <tr>
            <td><label for="location">Location</label></td>
            <td>: <input name="location" id="location" type="text" required></td>
        </tr>
        <tr>
            <td><label for="duration">Duration</label></td>
            <td>: <input name="duration" id="duration" type="text" required></td>
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
