<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="login" method="post">
    <div>
        <div>
            <label for="login">Login:</label>
            <input type="text" id="login" name="login">
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password">
        </div>
        <div>
            <input type="submit" value="Login">
        </div>
    </div>
</form>

<a href="registration.jsp">Register</a>
</body>
</html>
