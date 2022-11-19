<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/register" method="post">
    <div>
        <div>
            <label for="account_name">Name:</label>
            <input type="text" id="account_name" name="account_name">
        </div>
        <div>
            <label for="login">Login:</label>
            <input type="text" id="login" name="login">
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password">
        </div>
        <div>
            <input type="submit" value="LogUp">
        </div>
    </div>
</form>
</body>
</html>
