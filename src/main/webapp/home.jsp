<%@ page import="java.util.List" %>
<%@ page import="ru.javarush.quest.entity.Answer" %>
<%@ page import="ru.javarush.quest.entity.Account" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<head>
    <link rel="stylesheet" href="css/aliens.css">
    <title></title>
</head>

<body>
<div class="bg">
    <div style=" height: 100%; border: 1px solid black">

        <form action="/logic" method="GET">
            <%Account account = (Account) session.getAttribute("account");%>
            <div style="width: 10%; margin-left: 45%">
                <div style="height: 20vh; display: flex; justify-content: center; align-items: center">
                    <input type="submit" class="btn btn-light" value="START GAME"/>
                </div>
                <div style="top: 1px; height: 450px">
                    <a style="color: red; margin-left: 30%; top: 50%" href="login.jsp">LOG OUT</a>
                    <input type="hidden" name="account_name" value="<%=account.getName()%>">
                </div>
            </div>
        </form>

        <table id="statistics_table" class="table table-striped-columns">STATISTICS:
            <thead>
            <tr>
                <th>PLAYER NAME:</th>
                <th>GAME:</th>
                <th>WIN:</th>
                <th>GAME OVER:</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <%=account.getName()%>
                </td>
                <td>
                    <%=account.getPlayCount()%>
                </td>
                <td>
                    <%=account.getWinCount()%>
                </td>
                <td>
                    <%=account.getGameOverCount()%>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</html>