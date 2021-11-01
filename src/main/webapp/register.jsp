
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Student</title>
</head>
<body>
<form action="RegisterStudent" method="POST">
<input type="text" name="name"  placeholder="Enter your Name" required></input>
<input type="email" name="email"   placeholder="Enter your Email" required></input>
<input type="number" name="cgpa"  step="0.01" placeholder="Enter your Cgpa" required></input>
<input type="number" name="phoneNo"   placeholder="Enter your Phone Number" required></input>
<input type="text" name="registerNo"   placeholder="Enter your Register Number" ></input>
<input type="text" name="placedIn"   placeholder="Enter your placedIn" ></input>
<input type="text" name="placementStatus"   value="Not Placed" placeholder="Enter your placementStatus" disabled ></input>
    <input type="submit" value="Submit">
</form>
</body>
</html>
