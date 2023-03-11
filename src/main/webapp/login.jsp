<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

<head>
    <title></title>
</head>
<body>

<form action="login" method="POST">
    <div style="height: 100vh; display: flex; justify-content: center; align-items: center; flex-direction: column">
        <div style="width: 500px;display: flex">
        <div>
            <label for="login"></label>
            <input class="form-control" type="text" id="login" name="login" placeholder="Login">
        </div>
        <div class="mx-5">
            <label for="password"></label>
            <input class="form-control" type="text" id="password" name="password" placeholder="Password">
        </div>
        <div class="btn-primary">
            <input class="btn btn-primary" type="submit" value="Login">
        </div>
        </div>
        <div class="mt-1" style="width: 500px">
                <a href="registration.jsp">register</a>
        </div>

    </div>

</form>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

</html>
