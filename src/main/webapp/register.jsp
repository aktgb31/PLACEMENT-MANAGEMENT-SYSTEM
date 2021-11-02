<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Student</title>
</head>
<script type="text/javascript">
    function validate() {
        let registerNo = document.getElementById("registerNo").value;
        console.log(registerNo,registerNo.length);
        if(registerNo.length!=9)
        {
            alert("Register No. should be of length 9");
            return false;
        }
        let phoneNo = document.getElementById("phoneNo").value;
        console.log(phoneNo,phoneNo.length);
        if(phoneNo.length!=10)
        {
            alert("Phone No. should be of length 10");
            return false;
        }
        return true;
    }

</script>
<body style="text-align: center">
<form action="RegisterStudent" onsubmit="return validate()" method="POST">
    <h2 style="text-align: center;">Register as Student</h2>
    <table style="  margin-left: auto; margin-right:auto;">
        <tr>
            <td><label for="registerNo">Register No.</label></td>
            <td>: <input name="registerNo" type="text" id="registerNo" required></td>
        </tr>
        <tr>
            <td><label for="name">Name</label></td>
            <td>: <input name='name' type="text" id="name" required></td>
        </tr>
        <tr>
            <td><label for="password">Password</label></td>
            <td>: <input name="password" id="password" type="password" required></td>
        </tr>
        <tr>
            <td><label for="phoneNo">Mobile</label></td>
            <td>: <input name="phoneNo" type="tel" id="phoneNo" required></td>
        </tr>
        <tr>
            <td><label for="email">Email ID</label></td>
            <td>: <input name="email" type="email" id="email" required></td>
        </tr>

        <tr>
            <td><label for="cgpa">CGPA</label></td>
            <td>: <input name="cgpa" type="number" step=0.01 min='0' max='10' value='0' id="cgpa" required></td>
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


