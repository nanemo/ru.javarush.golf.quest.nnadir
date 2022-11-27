<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<head>
    <link rel="stylesheet" href="css/aliens.css">
    <title></title>
</head>
<body>
<form action="/register" method="post">
    <div style="width: 500px; margin: auto">
        <div class="input-group input-group-sm mb-3">
            <label class="input-group-text" for="account_name">Name:</label>
            <input class="form-control" type="text" id="account_name" name="account_name">
        </div>
        <div class="input-group input-group-sm mb-3">
            <label class="input-group-text" for="login">Login:</label>
            <input class="form-control" type="text" id="login" name="login">
        </div>
        <div class="input-group input-group-sm mb-3">
            <label class="input-group-text" for="password">Password:</label>
            <input class="form-control" type="text" id="password" name="password">
        </div>
        <div>
            <input class="btn btn-primary" type="submit" value="LogUp">
        </div>
    </div>
</form>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>
